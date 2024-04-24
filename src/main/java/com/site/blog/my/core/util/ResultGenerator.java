package com.site.blog.my.core.util;

import org.springframework.util.StringUtils;


public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static final String DEFAULT_FAIL_MESSAGE = "FAIL";
    private static final int RESULT_CODE_SUCCESS = 200;
    private static final int RESULT_CODE_SERVER_ERROR = 500;

    public static Result<Object> genSuccessResult() {
        return genSuccessResult(DEFAULT_SUCCESS_MESSAGE);
    }

    public static Result<Object> genSuccessResult(String message) {
        return genErrorResult(RESULT_CODE_SUCCESS, message);
    }

    public static Result<Object> genSuccessResult(Object data) {
        Result<Object> result = genErrorResult(RESULT_CODE_SUCCESS, DEFAULT_SUCCESS_MESSAGE);
        result.setData(data);
        return result;
    }

    public static Result<Object> genFailResult(String message) {
        Result<Object> result = new Result<>();
        result.setResultCode(RESULT_CODE_SERVER_ERROR);
        if (!StringUtils.hasText(message)) {
            result.setMessage(DEFAULT_FAIL_MESSAGE);
        } else {
            result.setMessage(message);
        }
        return result;
    }

    public static Result<Object> genErrorResult(int code, String message) {
        Result<Object> result = new Result<>();
        result.setResultCode(code);
        result.setMessage(message);
        return result;
    }
}
