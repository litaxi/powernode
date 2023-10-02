package com.powernode.bank.mapper;

import com.powernode.bank.pojo.Account;
import java.util.List;

/**
 * @Author wataxi @Date 2023/9/27 23:23 @Version 1.0
 */
public interface AccountMapper {

  /**
   * 新增账户
   * @param account
   */
  void insert(Account account);

  /**
   * 删除账户
   * @param actno
   * @return
   */
  int deleteByActno(String actno);

  /**
   * 更新账户
   * @param account
   * @return
   */
  int update(Account account);

  /**
   * 查询账户
   * @param actno
   * @return
   */
  Account selectByActno(String actno);

  /**
   * 查询所有账户信息
   * @return
   */
  List<Account> selectAll();
}
