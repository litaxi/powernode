package com.powernode.spring6.test;

import com.powernode.config.Spring6Config;
import com.powernode.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author wataxi @Date 2023/9/27 13:45 @Version 1.0
 */
public class SpringAOPTest {

  @Test
  public void testAOPByAnno(){
    ApplicationContext context = new AnnotationConfigApplicationContext(Spring6Config.class);
    UserService userService = context.getBean("userService", UserService.class);
    userService.login();
    userService.logout();
  }
  @Test
  public void testAOPByXML(){
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
        "spring-aspectj-aop-xml.xml");
    UserService userService = context.getBean("userService", UserService.class);
    userService.login();
    userService.logout();
  }


}
