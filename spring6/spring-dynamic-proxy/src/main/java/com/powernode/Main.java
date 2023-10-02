package com.powernode;

import com.powernode.proxy.jdk.OrderService;
import com.powernode.proxy.jdk.OrderServiceImpl;
import com.powernode.proxy.jdk.TimerAdvice;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author wataxi @Date 2023/9/27 8:46 @Version 1.0
 */
public class Main {
  public static void main(String[] args) {
    OrderService orderService = new OrderServiceImpl();
    TimerAdvice timerAdvice = new TimerAdvice();
    OrderService proxyObj = (OrderService) Proxy.newProxyInstance(orderService.getClass().getClassLoader(),
        orderService.getClass().getInterfaces(), new InvocationHandler() {
          @Override
          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            timerAdvice.beginTime();
            Object invoke = method.invoke(orderService, args);
            timerAdvice.endTime();
            return invoke;
          }
        });
    System.out.println(proxyObj.toString());
    proxyObj.generateOrder();
    proxyObj.delivery();
    proxyObj.warehouse();


  }
}
