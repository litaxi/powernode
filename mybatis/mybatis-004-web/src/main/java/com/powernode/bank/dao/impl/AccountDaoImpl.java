package com.powernode.bank.dao.impl;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @Author wataxi
 * @Date 2023/9/23 13:07
 * @Version 1.0
 */
public class AccountDaoImpl implements AccountDao {
    /**
     * 根据账号查询账号信息
     *
     * @param actno 账号
     * @return 账号信息
     */
    @Override
    public Account selectByActno(String actno) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Account account = sqlSession.selectOne("selectByActno", actno);
        return account;
    }

    /**
     * 根据账号更改账户余额，更新账户信息
     *
     * @param act 账号信息
     * @return 1表示更新成功，其他值表示更新失败
     */
    @Override
    public int updateByActno(Account act) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.update("updateByActno", act);
        return count;
    }
}
