package org.angrybeard.spiritredis.pubsub;

import lombok.extern.slf4j.Slf4j;
import org.angrybeard.spiritredis.dto.Message;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by angry_beary on 2019/9/8.
 */
@Slf4j
@Component
public class MessageListener {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void receiveMessage(Message message, String pattern) {
        if (isRan(message.getId(), "ok")) {
            log.info("topic ={} received={} ", pattern, message);
        }
    }

    private boolean isRan(String key, Object value) {
        return stringRedisTemplate.execute((RedisConnection conn) -> {
            try {
                return conn.setNX(stringRedisTemplate.getStringSerializer().serialize(key),
                        stringRedisTemplate.getStringSerializer().serialize(value.toString()));
            } finally {
                conn.close();
            }
        });

    }
}
