package com.powernode.bank.exceptions;

/**
 * 转账异常
 * @Author wataxi
 * @Date 2023/9/23 12:51
 * @Version 1.0
 */
public class TrensferException extends Exception {
    public TrensferException() {
    }
    public TrensferException(String message) {
        super(message);
    }
}
