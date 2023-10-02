package com.powernode.proxy.cglib;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @Author wataxi @Date 2023/9/27 9:49 @Version 1.0
 */
public class TimerMethodInterceptor implements MethodInterceptor {

  public TimerMethodInterceptor(TimerAdvice timerAdvice) {
    this.timerAdvice = timerAdvice;
  }

  private TimerAdvice timerAdvice;

  @Override
  public Object intercept(Object target, Method method, Object[] objects, MethodProxy methodProxy)
      throws Throwable {

    // 前置通知
    timerAdvice.before();
    Object invoke = methodProxy.invokeSuper(target, objects);
    // 后置通知
    timerAdvice.after();
    return invoke;
  }
}
