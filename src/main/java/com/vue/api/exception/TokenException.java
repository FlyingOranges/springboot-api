package com.vue.api.exception;

public class TokenException extends Exception {

    private String message;
    private Integer code;

    public TokenException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

}
