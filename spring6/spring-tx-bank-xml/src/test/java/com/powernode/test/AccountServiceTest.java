package com.powernode.test;

import com.powernode.bank.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author wataxi @Date 2023/9/27 17:50 @Version 1.0
 */
public class AccountServiceTest {

//  @Test
  public void testTransferByXML() {
    ApplicationContext context = new ClassPathXmlApplicationContext("Spring6Config.xml");
    AccountService accountService = context.getBean("accountService", AccountService.class);
    try {
      accountService.transfer("act-001", "act-002", 10000);
      System.out.println("转账成功");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
