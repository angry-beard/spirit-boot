package org.angrybeard.spiritboot.exception;

import lombok.extern.slf4j.Slf4j;
import org.angrybeard.spiritboot.dto.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by angry_beary on 2019/7/3.
 */
@Slf4j
@RestControllerAdvice
public class CustomExcetionHandler {

    @ExceptionHandler(value = Exception.class)
    BaseResponse handleException(Exception e, HttpServletRequest request) {
        log.error("url={},exception:", request.getRequestURL(), e);
        return BaseResponse.error(e.getMessage());
    }
}
