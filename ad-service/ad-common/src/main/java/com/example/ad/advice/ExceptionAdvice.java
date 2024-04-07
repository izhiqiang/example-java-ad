package com.example.ad.advice;

import com.example.ad.exception.BusinessException;
import com.example.ad.response.BaseResponse;
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
