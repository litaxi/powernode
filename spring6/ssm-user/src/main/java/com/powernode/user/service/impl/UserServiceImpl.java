package com.powernode.user.service.impl;

import com.powernode.user.mapper.UsersMapper;
import com.powernode.user.pojo.Users;
import com.powernode.user.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author wataxi @Date 2023/10/1 17:53 @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UsersMapper usersMapper;
  @Override
  public List<Users> selectUserPage(String userName, String userSex, int startRow) {
    return usersMapper.selectUserPage(userName, userSex, startRow);
  }

  @Override
  public int createUser(Users user) {
    return usersMapper.createUser(user);
  }

  @Override
  public int deleteUserById(String userId) {
    return usersMapper.deleteUserById(userId);
  }
}
