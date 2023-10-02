package com.powernode.bank.service.impl;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.dao.impl.AccountDaoImpl;
import com.powernode.bank.exceptions.MoneyNotEnoughException;
import com.powernode.bank.exceptions.TrensferException;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.service.AccountService;
import com.powernode.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author wataxi
 * @Date 2023/9/23 13:05
 * @Version 1.0
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();

    /**
     * 账户转账业务
     *
     * @param fromActno 转出账号
     * @param toActno   转入账号
     * @param money     转账金额
     */
    @Override
    public void Transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, TrensferException {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //1.先查询转出账号信息
        Account fromAct = accountDao.selectByActno(fromActno);
        //2.比对账户余额是否充足
        if (fromAct.getBalance() < money) {
            throw new MoneyNotEnoughException("对不起，您的账户余额不足！");
        }
        //3.扣除转出账号的余额
        fromAct.setBalance(fromAct.getBalance() - money);
        //4.增加转入账号的余额
        Account toAct = accountDao.selectByActno(toActno);
        toAct.setBalance(toAct.getBalance() + money);
        //5.更新账户余额
        int count = accountDao.updateByActno(fromAct);
        int x = 1 / 0;
        count += accountDao.updateByActno(toAct);
        if (count != 2) {
            throw new TrensferException("转账异常，未知原因！");
        }
        SqlSessionUtil.commit(sqlSession);
        SqlSessionUtil.close(sqlSession);
    }
}
