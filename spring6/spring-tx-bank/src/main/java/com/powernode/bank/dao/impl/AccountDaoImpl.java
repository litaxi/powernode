package com.powernode.bank.dao.impl;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Author wataxi @Date 2023/9/27 17:27 @Version 1.0
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

  @Resource(name = "jdbcTemplate")
  private JdbcTemplate jdbcTemplate;

  /**
   * 根据账号查询余额
   *
   * @param actno
   * @return
   */
  @Override
  public Account select(String actno) {
    String sql = "select actno, balance from t_act where actno = ?";
    return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), actno);
  }

  /**
   * 更新账户
   *
   * @param actno
   * @param balance
   * @return
   */
  @Override
  public int update(String actno, double balance) {
    String sql = "update t_act set balance =? where actno =?";
    return jdbcTemplate.update(sql, balance, actno);
  }
}
