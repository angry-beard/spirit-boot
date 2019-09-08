package org.angrybeard.spiritredis.service.impl;

import org.angrybeard.spiritredis.constants.MessageChannel;
import org.angrybeard.spiritredis.dto.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


/**
 * Created by angry_beary on 2019/9/8.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisMqTest {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void sendMessage() {
        for (int i = 0; i < 1000; i++) {
            Message message = Message.builder()
                    .id(i + "")
                    .context("数羊： 第" + i + "只")
                    .build();
            redisTemplate.convertAndSend(MessageChannel.NOTICE_MESSAGE.getMsgChannel(), message);
        }
    }
}