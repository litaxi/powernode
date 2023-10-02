package com.powernode.beans;

import com.powernode.beans.config.Spring6Config;
import com.powernode.beans.service.StuService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author wataxi @Date 2023/9/26 15:43 @Version 1.0
 */
public class IoCAnnotationTest {

  @Test
  public void testIoCAnnotationTest() {
    ApplicationContext context = new AnnotationConfigApplicationContext(Spring6Config.class);
    StuService stuService = context.getBean("stuService", StuService.class);
    stuService.saveStuInfo();
  }
}
