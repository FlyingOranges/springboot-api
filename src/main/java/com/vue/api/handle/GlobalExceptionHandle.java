package com.vue.api.handle;

import com.vue.api.exception.AuthException;
import com.vue.api.utils.HttpUtils;
import com.vue.api.utilsPackages.ApiResponse;
import org.springframework.beans.propertyeditors.FileEditor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandle {

    /**
     * 登录身份验证异常
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = AuthException.class)
    public ApiResponse AuthExceptionHandle(AuthException e) {
        return HttpUtils.apiError(e.getMessage(), e.getCode());
    }

    /**
     * MethodArgumentNotValidException
     *
     * @return
     */
//    @ResponseBody
//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    public ApiResponse MethodArgumentNotValidException(MethodArgumentNotValidException e) {
//
//        BindingResult bindingResult = e.getBindingResult();
//
//        String errorMesssage = "Invalid Request:\n";
//
//        for (FieldError fieldError : bindingResult.getFieldErrors()) {
//            errorMesssage += fieldError.getDefaultMessage() + "\n";
//        }
//
//        return HttpUtils.apiError(errorMesssage);
//    }

}
