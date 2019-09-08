package org.angrybeard.spiritredis.distributedlock;

import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by angry_beary on 2019/9/8.
 */
@Slf4j
@Component
public class DistributedLock {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 加锁
     *
     * @param messageId
     * @param timeStamp
     * @return
     */
    public boolean lock(String messageId, String timeStamp) {
        if (stringRedisTemplate.opsForValue().setIfAbsent(messageId, timeStamp)) {
            return true;
        }

        String currentLock = stringRedisTemplate.opsForValue().get(messageId);
        // 如果锁过期 currentLock不为空且小于当前时间
        if (!Strings.isNullOrEmpty(currentLock) && Long.parseLong(currentLock) < System.currentTimeMillis()) {
            // 获取上一个锁的时间value 对应getset，如果lock存在
            String preLock = stringRedisTemplate.opsForValue().getAndSet(messageId, timeStamp);

            // 假设两个线程同时进来这里，因为key被占用了，而且锁过期了。获取的值currentLock=A(get取的旧的值肯定是一样的),两个线程的timeStamp都是B,key都是K.锁时间已经过期了。
            // 而这里面的getAndSet一次只会一个执行，也就是一个执行之后，上一个的timeStamp已经变成了B。只有一个线程获取的上一个值会是A，另一个线程拿到的值是B。
            if (!Strings.isNullOrEmpty(preLock) && preLock.equals(currentLock)) {
                // preLock不为空且preLock等于currentLock，也就是校验是不是上个对应的商品时间戳，也是防止并发
                return true;
            }
        }
        return false;
    }


    /**
     * 解锁
     *
     * @param target
     * @param timeStamp
     */
    public void unlock(String target, String timeStamp) {
        try {
            String currentValue = stringRedisTemplate.opsForValue().get(target);
            if (!Strings.isNullOrEmpty(currentValue) && currentValue.equals(timeStamp)) {
                // 删除锁状态
                stringRedisTemplate.opsForValue().getOperations().delete(target);
            }
        } catch (Exception e) {
            log.error("解锁异常{}", e);
        }
    }
}
