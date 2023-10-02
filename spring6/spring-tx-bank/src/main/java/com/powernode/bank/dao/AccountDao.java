package com.powernode.bank.dao;

import com.powernode.bank.pojo.Account;

/**
 * @Author wataxi @Date 2023/9/27 17:25 @Version 1.0
 */
public interface AccountDao {

  /**
   * 根据账号查询余额
   * @param actno
   * @return
   */
  Account select(String actno);

  /**
   * 更新账户
   * @param actno
   * @param balance
   * @return
   */
  int update(String actno, double balance);

}
