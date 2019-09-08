package org.angrybeard.spiritredis.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by angry_beary on 2019/9/5.
 */

@AllArgsConstructor
@Getter
public enum MessageChannel {

    NOTICE_MESSAGE("message.notice.channel", "通知消息渠道"),
    MESSAGE_PATTERN("message.*", "渠道订阅表达式");

    private String msgChannel;
    private String msgDesc;
}
