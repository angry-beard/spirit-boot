package org.angrybeard.spiritredis.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.angrybeard.spiritredis.dto.Message;
import org.angrybeard.spiritredis.service.IMessageHandlerService;
import org.springframework.stereotype.Service;

/**
 * Created by angry_beary on 2019/9/8.
 */
@Slf4j
@Service
public class MessageHandlerService implements IMessageHandlerService {

    @Override
    public void handlerMessage(Message message) {
        log.info("消费数据有 data={}", JSONObject.toJSONString(message));
    }
}
