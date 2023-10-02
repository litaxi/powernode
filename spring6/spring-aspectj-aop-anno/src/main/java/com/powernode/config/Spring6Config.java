package com.powernode.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author wataxi @Date 2023/9/27 15:38 @Version 1.0
 */
@Configuration
@ComponentScan("com.powernode")
@EnableAspectJAutoProxy(proxyTargetClass = true) // 启用aspect的自动代理机制
public class Spring6Config {}
