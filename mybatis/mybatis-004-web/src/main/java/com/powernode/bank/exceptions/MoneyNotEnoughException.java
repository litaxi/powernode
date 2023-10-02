package com.powernode.bank.exceptions;

/**
 * 账户余额不足异常
 * @Author wataxi
 * @Date 2023/9/23 12:52
 * @Version 1.0
 */
public class MoneyNotEnoughException extends Exception {
    public MoneyNotEnoughException(String message) {
        super(message);
    }
    public MoneyNotEnoughException(){}
}
