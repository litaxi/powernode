package com.powernode.service;

import java.text.SimpleDateFormat;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Author wataxi @Date 2023/9/27 10:45 @Version 1.0
 */
@Component
@Aspect
public final class TimerAdvice {

  private long startTime;
  private long endTime;

  public static final SimpleDateFormat SIMPLE_DATE_FORMAT =
      new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");

  @Before("execution(* com.powernode.service.UserService.*(..))")
  public void beforeAdvice() {
    System.out.println("开始时间：" + SIMPLE_DATE_FORMAT.format(System.currentTimeMillis()));
  }
  @AfterReturning("execution(* com.powernode.service.UserService.*(..))")
  public void afterReturningAdvice() {
    System.out.println("结束时间：" + SIMPLE_DATE_FORMAT.format(System.currentTimeMillis()));
  }

  @Around("execution(* com.powernode.service.UserService.*(..))")
  public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    this.startTime = System.currentTimeMillis();
    System.out.println("begin：" + this.startTime);
    proceedingJoinPoint.proceed();
    System.out.println("执行时间：" + (this.endTime - this.startTime) + "毫秒");
  }

  @After("execution(* com.powernode.service.UserService.*(..))")
  public void afterAdvice() {
    this.endTime = System.currentTimeMillis();
    System.out.println("end：" + this.endTime);
  }
  @AfterThrowing("execution(* com.powernode.service.UserService.*(..))")
  public void afterThrowingAdvice() {
    System.err.println("警告。。。。。。。。。。。。。。");
  }
}
