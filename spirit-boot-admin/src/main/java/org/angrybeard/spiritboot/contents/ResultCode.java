package org.angrybeard.spiritboot.contents;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by angry_beary on 2019/7/1.
 */
@Getter
@AllArgsConstructor
public enum ResultCode {

    C200("200", "Success"),
    C403("403", "Forbidden"),
    C400("400", "Bad Request"),
    C404("404", "Not Found"),
    C410("410", "Gone"),
    C401("-401", "用户未登录"),
    TEST("TEST", "hello {0} and hellow {1}"),
    C500("500", "Internal Server Error"),
    PM_000001("PM_000001", "促销内部异常");

    private String code;
    private String desc;
}
