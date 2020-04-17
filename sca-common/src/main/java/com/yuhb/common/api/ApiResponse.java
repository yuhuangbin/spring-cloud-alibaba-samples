package com.yuhb.common.api;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yu.hb on 2020-01-03
 */
@Data
public class ApiResponse<T> implements Serializable {

    public static final ApiResponse SUCCESS = new ApiResponse();
    public static final ApiResponse ERROR = new ApiResponse(ResponseInfo.ERROR);
    public static final ApiResponse LIMIT = new ApiResponse(ResponseInfo.LIMIT_ERROR);

    private int code; // 返回响应码:200=成功返回，其他=错误返回

    private String msg; // 返回响应消息

    private T data; // 返回数据

    private Integer totalNum;

    private Integer pageIndex;

    private Integer pageSize;

    private Integer totalPage;

    /**
     * 成功返回
     * @param <T>
     * @return
     */
    public static <T> ApiResponse<T> success() {
        return new ApiResponse(ResponseInfo.SUCCESS.code, ResponseInfo.SUCCESS.msg);
    }

    /**
     * 成功返回
     * @param data 数据
     * @param <T>
     * @return
     */
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse(ResponseInfo.SUCCESS.code, ResponseInfo.SUCCESS.msg, data);
    }

    /**
     * 错误返回
     * @param <T>
     * @return
     */
    public static <T> ApiResponse<T> error() {
        return new ApiResponse(ResponseInfo.ERROR.code, ResponseInfo.ERROR.msg);
    }

    /**
     * 错误返回
     * @param message 错误备注
     * @param <T>
     * @return
     */
    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse(ResponseInfo.ERROR.code, message);
    }


    public static <T> ApiResponse<T> of(ResponseInfo responseInfo) {
        return new ApiResponse(responseInfo);
    }

    public ApiResponse() {
        this(ResponseInfo.SUCCESS);
    }


    public ApiResponse(ResponseInfo responseInfo) {
        this.code = responseInfo.code;
        this.msg = responseInfo.msg;
    }

    public ApiResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ApiResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ApiResponse(int code, String msg, T data, Integer totalNum, Integer pageIndex, Integer pageSize) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.totalNum = totalNum;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalPage = (null == pageSize || pageSize == 0) ? null : (totalNum % pageSize == 0 ? totalNum / pageSize : (totalNum / pageSize + 1));
    }
}
