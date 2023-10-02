package com.powernode.bank;

import com.powernode.bank.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @Author wataxi @Date 2023/9/28 0:18 @Version 1.0
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:Spring6Config.xml")
public class AccountTest {

  @Autowired
  private AccountService accountService;
  @Test
  public void testTransfer(){
    try {
      accountService.transfer("act-001","act-002",10000);
      System.out.println("转账成功！");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
