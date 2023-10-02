package com.powernode.proxy.jdk;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author wataxi @Date 2023/9/27 8:55 @Version 1.0
 */
public class TimerAdvice {

  /** 开始时间 */
  public void beginTime() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println(sdf.format(new Date()));
  }

  /** 结束时间 */
  public void endTime() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println(sdf.format(new Date()));
  }
}
