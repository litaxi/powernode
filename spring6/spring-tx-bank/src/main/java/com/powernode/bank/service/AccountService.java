package com.powernode.bank.service;


import org.springframework.transaction.annotation.Transactional;

/**
 * @Author wataxi @Date 2023/9/27 17:34 @Version 1.0
 */
public interface AccountService {

  /**
   * 转账业务
   * @param fromNo
   * @param toNo
   * @param amount
   */
  @Transactional
  void transfer(String fromNo, String toNo, double amount);
}
