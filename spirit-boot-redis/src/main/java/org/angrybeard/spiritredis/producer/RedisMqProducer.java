package org.angrybeard.spiritredis.producer;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.angrybeard.spiritredis.constants.MessageChannel;
import org.angrybeard.spiritredis.dto.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by angry_beary on 2019/9/4.
 */
@Slf4j
@Component
public class RedisMqProducer {

    @Resource
    RedisTemplate<String, Message> redisTemplate;

    public Long sendMessage(Message message) {
        log.info("发送数据:{}", JSONObject.toJSONString(message));
        redisTemplate.opsForList().rightPush(MessageChannel.NOTICE_MESSAGE.getMsgChannel(), message);
        log.info("发送完成");
        //Object obj = redisTemplate.opsForList().leftPop(MessageChannel.NOTICE_MESSAGE.getMsgKey());
        //log.info("取出数据obj={}", JSONObject.toJSONString(obj));
        return 1L;
    }

}