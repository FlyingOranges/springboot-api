package com.vue.api.utils;

import com.vue.api.utilsPackages.ApiResponse;

public class HttpUtils {

    /**
     * 正确回传
     *
     * @param message string 信息提示
     * @param data    Object 回传数据
     * @return
     */
    public static ApiResponse apiSuccess(String message, Object data) {
        if (message == null) {
            message = "success";
        }
        ApiResponse result = new ApiResponse();

        result.setCode(0);
        result.setMessage(message);
        result.setData(data);

        return result;
    }

    public static ApiResponse apiSuccess(String message) {
        if (message == null) {
            message = "success";
        }

        ApiResponse result = new ApiResponse();

        result.setCode(0);
        result.setMessage(message);

        return result;
    }

    /**
     * 错误回传
     *
     * @param message
     * @param code
     * @return
     */
    public static ApiResponse apiError(String message, Integer code) {
        if (message == null) {
            message = "error";
        }

        ApiResponse result = new ApiResponse();

        result.setMessage(message);
        result.setCode(code);

        return result;
    }

    public static ApiResponse apiError(String message) {
        if (message == null) {
            message = "error";
        }

        ApiResponse result = new ApiResponse();

        result.setCode(1);
        result.setMessage(message);

        return result;
    }
}
