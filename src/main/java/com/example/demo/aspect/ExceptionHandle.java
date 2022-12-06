package com.example.demo.aspect;

import com.example.demo.exception.REnum;
import com.example.demo.exception.RException;
import com.example.demo.utils.RUtil;
import com.example.demo.vo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public Result handle(Exception e){
        if (e instanceof RException){
            RException rException = (RException) e;
            return RUtil.error(rException.getCode(), rException.getMessage());
        }

        return RUtil.error(REnum.UNKONW_ERROR);
    }
}
