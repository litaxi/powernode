package com.powernode.bank.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 账户类，封装账户数据
 * @Author wataxi
 * @Date 2023/9/23 12:00
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Long id;
    private String actno;
    private Double balance;
}
