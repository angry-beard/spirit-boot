package org.angrybeard.spiritboot.dto;


import lombok.*;
import org.angrybeard.spiritboot.contents.ResultCode;

/**
 * code和message默认使用 200段
 *
 * @param <>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {

    private String code;
    private String msg;
    private T data;

    public static <T> BaseResponse<T> success() {
        return new BaseResponse<T>(ResultCode.C200.getCode(), ResultCode.C200.getDesc(), null);
    }

    public static <T> BaseResponse<T> success(String message) {
        return new BaseResponse<T>(ResultCode.C200.getCode(), message, null);
    }

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<T>(ResultCode.C200.getCode(), ResultCode.C200.getDesc(), data);
    }

    public static <T> BaseResponse<T> success(String message, T data) {
        return new BaseResponse<T>(ResultCode.C200.getCode(), message, data);
    }

    public static <T> BaseResponse<T> error() {
        return new BaseResponse<T>(ResultCode.C500.getCode(), ResultCode.C500.getDesc(), null);
    }

    public static <T> BaseResponse<T> error(String message) {
        return new BaseResponse<T>(ResultCode.C500.getCode(), message, null);
    }

    public static <T> BaseResponse<T> badRequst() {
        return new BaseResponse<T>(ResultCode.C410.getCode(), ResultCode.C410.getDesc(), null);
    }

    public void setData(T data) {
        this.data = data;
    }

}