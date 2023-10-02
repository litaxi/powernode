package com.powernode.bank.service.impl;

import com.powernode.bank.mapper.AccountMapper;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.service.AccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author wataxi @Date 2023/9/27 23:42 @Version 1.0
 */
@Service
public class AccountServiceImpl implements AccountService {
  @Autowired private AccountMapper accountMapper;

  /**
   * 开户
   *
   * @param account
   */
  @Override
  public void save(Account account) {
    accountMapper.insert(account);
  }

  /**
   * 销户
   *
   * @param actno
   * @return
   */
  @Override
  public int deleteByActno(String actno) {
    return accountMapper.deleteByActno(actno);
  }

  /**
   * 根据账号查询账户信息
   *
   * @param actno
   * @return
   */
  @Override
  public Account getByActno(String actno) {
    return accountMapper.selectByActno(actno);
  }

  /**
   * 查询所有账户信息
   *
   * @return
   */
  @Override
  public List<Account> getAllAccounts() {
    return accountMapper.selectAll();
  }

  /**
   * 更新修改账户
   *
   * @param account
   * @return
   */
  @Override
  public int update(Account account) {
    return 0;
  }

  /**
   * 转账业务
   *
   * @param from
   * @param to
   * @param amount
   */
  @Override
  public void transfer(String from, String to, double amount) {
    if (amount == 0) {
      return;
    }
    Account fromAct = accountMapper.selectByActno(from);
    if (fromAct != null && fromAct.getBalance() > amount) {
      Account toAct = accountMapper.selectByActno(to);
      fromAct.setBalance(fromAct.getBalance() - amount);
      int count = accountMapper.update(fromAct);
      //if (true) throw new RuntimeException("未知异常，请联系客服！");
      toAct.setBalance(toAct.getBalance() + amount);
      count += accountMapper.update(toAct);
      if (count != 2) {
        throw new RuntimeException("转账失败，请联系银行!");
      }
    } else {
      throw new RuntimeException("账户余额不足!");
    }
  }
}
