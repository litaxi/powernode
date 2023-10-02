package com.powernode.bank.service;

import com.powernode.bank.pojo.Account;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author wataxi @Date 2023/9/27 23:35 @Version 1.0
 */
@Transactional
public interface AccountService {

  /**
   * 开户
   *
   * @param account
   */
  void save(Account account);

  /**
   * 销户
   *
   * @param actno
   * @return
   */
  int deleteByActno(String actno);

  /**
   * 根据账号查询账户信息
   *
   * @param actno
   * @return
   */
  @Transactional(readOnly = true)
  Account getByActno(String actno);

  /**
   * 查询所有账户信息
   *
   * @return
   */
  @Transactional(readOnly = true)
  List<Account> getAllAccounts();

  /**
   * 更新修改账户
   *
   * @param account
   * @return
   */
  int update(Account account);

  /**
   * 转账业务
   *
   * @param from
   * @param to
   * @param amount
   */
  void transfer(String from, String to, double amount);
}
