package com.powernode.proxy.cglib;


import net.sf.cglib.proxy.Enhancer;

/**
 * @author 动力节点
 * @version 1.0
 * @className Client
 * @since 1.0
 */
public class Client {
  public static void main(String[] args) {
    // 创建字节码增强器
    Enhancer enhancer = new Enhancer();
    // 告诉cglib要继承哪个类
    enhancer.setSuperclass(UserService.class);
    // 设置回调接口
    enhancer.setCallback((new TimerMethodInterceptor(new TimerAdvice())));
    // 生成源码，编译class，加载到JVM，并创建代理对象
    UserService userService = (UserService) enhancer.create();
    userService.login();
    userService.logout();
  }

}
