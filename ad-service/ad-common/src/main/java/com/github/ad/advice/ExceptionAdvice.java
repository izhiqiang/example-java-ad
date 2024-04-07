package com.github.ad.advice;

import com.github.ad.exception.BusinessException;
import com.github.ad.response.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = BusinessException.class)
    public BaseResponse<String> handlerException(HttpServletRequest req, BusinessException e) {
        BaseResponse<String> response = new BaseResponse(-1, "The server has run away");
        response.setData(e.getMessage());
        return response;
    }
}
