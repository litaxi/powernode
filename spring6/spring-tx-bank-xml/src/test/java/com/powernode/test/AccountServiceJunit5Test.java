package com.powernode.test;

import com.powernode.bank.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @Author wataxi @Date 2023/9/27 17:50 @Version 1.0
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:Spring6Config.xml")
public class AccountServiceJunit5Test {
  @Autowired private AccountService accountService;

  @Test
  public void testTransferByXML() {
    for (int i = 0; i < 5; i++) {
      try {
        accountService.transfer("act-002", "act-001", 10000);
        System.out.println("转账成功");
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }
}
