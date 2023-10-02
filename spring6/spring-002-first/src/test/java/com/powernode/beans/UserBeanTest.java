package com.powernode.beans;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author wataxi @Date 2023/9/25 12:02 @Version 1.0
 */
public class UserBeanTest {
  private final Logger logger = LoggerFactory.getLogger(UserBeanTest.class);

  @Test
  public void testUserBean() throws Exception {
    ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
    User bean = app.getBean(User.class);
    logger.info("这是一条信息");
    logger.error("这是一条错误信息");
    logger.warn("这是一条警告信息");
    System.out.println(bean);
  }
}
