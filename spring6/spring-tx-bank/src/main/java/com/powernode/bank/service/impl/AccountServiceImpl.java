package com.powernode.bank.service.impl;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author wataxi @Date 2023/9/27 17:35 @Version 1.0
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

  @Autowired private AccountDao accountDao;

  /**
   * 转账业务
   *
   * @param fromNo
   * @param toNo
   * @param amount
   */
  @Override
  public void transfer(String fromNo, String toNo, double amount) {
    Account fromAct = accountDao.select(fromNo);
    if (fromAct != null && fromAct.getBalance() > amount) {
      fromAct.setBalance(fromAct.getBalance() - amount);
      int count = accountDao.update(fromAct.getActno(), fromAct.getBalance());
      int x = 1 / 0;
      Account toAct = accountDao.select(toNo);
      if (toAct != null) {
        toAct.setBalance(toAct.getBalance() + amount);
        count += accountDao.update(toAct.getActno(), toAct.getBalance());
        if (count != 2) {
          throw new RuntimeException("转账失败，请联系银行！");
        }
      }
    } else {
      throw new RuntimeException("账户余额不足！");
    }
  }
}
