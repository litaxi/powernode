package com.powernode.proxy.cglib;

import java.text.SimpleDateFormat;

/**
 * @Author wataxi @Date 2023/9/27 10:45 @Version 1.0
 */
public final class TimerAdvice {
  public static final SimpleDateFormat SIMPLE_DATE_FORMAT =
      new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");

  public void before() {
    System.out.println("开始时间：" + SIMPLE_DATE_FORMAT.format(System.currentTimeMillis()));
  }

  public void after() {
    System.out.println("结束时间：" + SIMPLE_DATE_FORMAT.format(System.currentTimeMillis()));
  }
}
