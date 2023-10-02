package com.powernode.service;

import org.springframework.stereotype.Service;

/**
 * @author 动力节点
 * @version 1.0
 * @className UserService
 * @since 1.0
 **/
@Service
public class UserService {

    public void login(){
        System.out.println("用户正在登录系统....");
    }

    public void logout(){
        System.out.println("用户正在退出系统....");
    }
}