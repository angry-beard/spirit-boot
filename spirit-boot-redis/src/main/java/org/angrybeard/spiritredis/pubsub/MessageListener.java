package org.angrybeard.spiritredis.pubsub;

import lombok.extern.slf4j.Slf4j;
import org.angrybeard.spiritredis.dto.Message;
import org.springframework.stereotype.Component;

/**
 * Created by angry_beary on 2019/9/8.
 */
@Slf4j
@Component
public class MessageListener {

    public void receiveMessage(Message message, String pattern) {
        log.info("topic ={} received={} ", pattern, message);
    }
}
