package org.angrybeard.spiritredis.service;

import org.angrybeard.spiritredis.dto.Message;

/**
 * Created by angry_beary on 2019/9/8.
 */
public interface IMessageHandlerService {
    void handlerMessage(Message message);
}
