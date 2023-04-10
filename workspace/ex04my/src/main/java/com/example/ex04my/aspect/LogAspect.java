package com.example.ex04my.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Configuration
@Slf4j
public class LogAspect {
    
    @Before("@annotation(com.example.ex04my.aspect.annotation.LogStatus)")
    public void beforeStart(JoinPoint joinPoint){
        log.info("join point: " + joinPoint);
        log.info("proxy: " + joinPoint.getThis());
        log.info("method: " + joinPoint.getSignature().getName());
        log.info("arguments: " + Arrays.stream(joinPoint.getArgs()).map(String::valueOf).collect(Collectors.joining(", ")));
    }

    @After(value = "@annotation(com.example.ex04my.aspect.annotation.LogStatus)")
    public void after(JoinPoint joinPoint){
        log.info("method: " + joinPoint.getSignature().getName());
        log.info("arguments: " + Arrays.stream(joinPoint.getArgs()).map(String::valueOf).collect(Collectors.joining(", ")));
    }


    @AfterReturning(value = "@annotation(com.example.ex04my.aspect.annotation.LogStatus)", returning = "returnValue")
    public void afterEnd(JoinPoint joinPoint, Integer returnValue){
        log.info("method: " + joinPoint.getSignature().getName());
        log.info("arguments: " + Arrays.stream(joinPoint.getArgs()).map(String::valueOf).collect(Collectors.joining(", ")));
        log.info("returnValue: " + returnValue);
    }

    @AfterThrowing(value = "@annotation(com.example.ex04my.aspect.annotation.LogStatus)", throwing = "e")
    public void afterEnd(Exception e){
        log.info("error message: "  + e.getMessage());
        log.info("wrong parameter!");
    }

    @Around("@annotation(com.example.ex04my.aspect.annotation.LogStatus)")
    public Integer around(ProceedingJoinPoint joinPoint) {
        Integer result = null;
        log.info("proceedingJoinPoint: " + joinPoint);
        try {
            result = (Integer)joinPoint.proceed(new Object[] {"1", "6"});
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result + 10;
    }
}
