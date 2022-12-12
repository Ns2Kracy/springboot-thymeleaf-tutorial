package com.example.demo.aspect;

import com.example.demo.exception.REnum;
import com.example.demo.exception.RException;
import com.example.demo.utils.ResultUtil;
import com.example.demo.model.Result;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public Result<Object> handle(Exception e){
        if (e instanceof RException){
            RException rException = (RException) e;
            return ResultUtil.error(rException.getCode(), rException.getMessage());
        }

        return ResultUtil.error(REnum.UNKNOWN_ERROR);
    }
}
