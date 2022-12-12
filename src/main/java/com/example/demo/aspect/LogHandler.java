package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogHandler {
    @Pointcut("execution(public * com.example.demo.webapi.StudentResController.*(..))")
    public void log() {}

    @Before("log()")
    public void doBefore() {
        System.out.println("doBefore");
    }

    @After("log()")
    public void doAfter() {
        System.out.println("doAfter");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        log.info("response={}", object);
    }
}
