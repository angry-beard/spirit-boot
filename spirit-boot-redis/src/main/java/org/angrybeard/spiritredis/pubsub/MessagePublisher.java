package org.angrybeard.spiritredis.pubsub;

import lombok.extern.slf4j.Slf4j;
import org.angrybeard.spiritredis.constants.MessageChannel;
import org.angrybeard.spiritredis.dto.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by angry_beary on 2019/9/8.
 */
@Slf4j
@Component
public class MessagePublisher {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    //@Scheduled(initialDelay = 5000, fixedDelay = 10000)
    private void sendMessage() {
        for (int i = 0; i < 10; i++) {
            Message message = Message.builder()
                    .id(i + "")
                    .context("数羊： 第" + i + "只")
                    .build();
            redisTemplate.convertAndSend(MessageChannel.NOTICE_MESSAGE.getMsgChannel(), message);
            log.info("发送消息:message={}", message);
        }
    }
}
