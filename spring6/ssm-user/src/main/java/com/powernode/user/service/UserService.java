package com.powernode.user.service;

import com.powernode.user.pojo.Users;
import java.util.List;

/**
 * @Author wataxi @Date 2023/10/1 17:50 @Version 1.0
 */
public interface UserService {

  List<Users> selectUserPage(String userName, String userSex,int startRow);

  int createUser(Users user);

  int deleteUserById(String userId);
}
