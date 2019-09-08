package org.angrybeard.spiritredis.consumer;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.angrybeard.spiritredis.constants.MessageChannel;
import org.angrybeard.spiritredis.dto.Message;
import org.angrybeard.spiritredis.service.IMessageHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by angry_beary on 2019/9/4.
 */
@Slf4j
@Component
public class RedisMqConsumer {

    @Resource
    protected RedisTemplate<String, Message> redisTemplate;
    @Autowired
    private IMessageHandlerService messageHandlerService;

    //@Scheduled(initialDelay = 5000, fixedDelay = 10000)
    public void receiveMessage() {
        Message message = redisTemplate.opsForList().rightPop(MessageChannel.NOTICE_MESSAGE.getMsgChannel(), 0, TimeUnit.SECONDS);
        log.info("接收数据:{}", JSONObject.toJSONString(message));
        messageHandlerService.handlerMessage(message);
    }
}
