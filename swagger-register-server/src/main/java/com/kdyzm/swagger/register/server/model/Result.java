package com.kdyzm.swagger.register.server.model;


import com.kdyzm.swagger.register.server.model.constants.ResultConstants;
import lombok.Data;

/**
 * @author kdyzm
 * @date 2021/7/1
 */
@Data
public class Result<T> {

    private T data;

    private String msg;

    /**
     * @see ResultConstants
     */
    private Integer code;

    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        result.setMsg("OK");
        result.setCode(ResultConstants.SUCCESS);
        return result;
    }

    public static <T> Result<T> fail(String msg) {
        Result<T> result = new Result<>();
        result.setData(null);
        result.setMsg(msg);
        result.setCode(ResultConstants.FAIL);
        return result;
    }
}
