package com.wuqi.netcloud.commons;

import java.util.ArrayList;
import java.util.List;

public final class ResultWrapper<T> {
    private boolean status;
    private Integer code;
    private String message;
    private T data;

    public ResultWrapper() {
    }

    public ResultWrapper(boolean status, Integer code, String message, T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResultWrapper success(T item) {
        return new ResultWrapper<>(true, 200, "OK", item);
    }

    public static <T> ResultWrapper success(int totalSize, List<T> items) {
        return success(totalSize, 1, items);
    }

    public static <T> ResultWrapper success(int totalSize, PageableParams params, List<T> items) {
        Data<T> data = new Data<>(totalSize, items);
        data.setPageSize(params.getCount());
        return new ResultWrapper<>(true, 200, "OK", data);
    }

    public static <T> ResultWrapper success(int totalSize,int pageSize, List<T> items) {
        Data<T> data = new Data<>(totalSize, items);
        data.setPageSize(pageSize);
        return new ResultWrapper<>(true, 200, "OK", data);
    }

    public static ResultWrapper error(int code, String message) {
        return new ResultWrapper<>(false, code, message, null);
    }

    public static ResultWrapper success(String message) {
        return new ResultWrapper<>(true, 200, message, null);
    }

    public static ResultWrapper success() {
        return new ResultWrapper<>(true, 200, "OK", null);
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
