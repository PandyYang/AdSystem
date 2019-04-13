package com.pandy.ad.advice;

import com.pandy.ad.exception.AdException;
import com.pandy.ad.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Pandy
 * @Date: 2019/4/13 8:47
 * @Version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = AdException.class)
    public CommonResponse<String> handlerAdException(HttpServletRequest req,
                                                     AdException ex){
        CommonResponse<String> response = new CommonResponse<>(-1,"error");
        response.setData(ex.getMessage());
        return response;
    }
}
