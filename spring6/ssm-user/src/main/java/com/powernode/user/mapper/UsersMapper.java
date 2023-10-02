package com.powernode.user.mapper;

import com.powernode.user.pojo.Users;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author wataxi @Date 2023/10/1 17:01 @Version 1.0
 */
public interface UsersMapper {

  List<Users> selectUserPage(
      @Param("userName") String userName,
      @Param("userSex") String userSex,
      @Param("startRow") int startRow);

  int createUser(Users user);

  int deleteUserById(String userId);

  int getRowCount(@Param("userName") String userName, @Param("userSex") String userSex);
}
