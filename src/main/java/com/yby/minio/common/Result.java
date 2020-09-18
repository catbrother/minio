package com.yby.minio.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @Author yby
 * @Date 2020/9/17 17:35
 **/
@Data
public class Result<T> {

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回信息提示
     */
    private String message;

    /**
     * 数据对象
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
