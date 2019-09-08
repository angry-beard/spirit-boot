package org.angrybeard.spiritredis.pubsub;

import lombok.extern.slf4j.Slf4j;
import org.angrybeard.spiritredis.distributedlock.DistributedLock;
import org.angrybeard.spiritredis.dto.Message;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by angry_beary on 2019/9/8.
 */
@Slf4j
@Component
public class MessageListener {

    @Resource
    private DistributedLock distributedLock;

    public void receiveMessage(Message message, String pattern) {
        long time = System.currentTimeMillis() + 5000;
        try {
            if (distributedLock.lock(message.getId(), String.valueOf(time))) {
                log.info("topic ={} received={} ", pattern, message);
            }
        } finally {
            distributedLock.unlock(message.getId(), String.valueOf(time));
        }

    }
}
