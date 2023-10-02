package com.powernode.test;

import com.powernode.bank.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author wataxi @Date 2023/9/27 17:50 @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:Spring6Config.xml")
public class AccountServiceJunit4Test {

  @Autowired
  private AccountService accountService;
  @Test
  public void testTransferByXML() {
    try {
      accountService.transfer("act-001", "act-002", 10000);
      System.out.println("转账成功");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
