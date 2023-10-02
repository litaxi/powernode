package com.powernode.users;

import com.powernode.user.pojo.Users;
import com.powernode.user.service.UserService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @Author wataxi @Date 2023/10/1 17:56 @Version 1.0
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:application-mapper.xml","classpath:application-service.xml"})
public class UserTest {
  @Autowired
  private UserService userService;

  @Test
  void testSelectUserPage() {
    String userName = "";
    String userSex="男";
    int startRow = 0;
    List<Users> users =
        userService.selectUserPage(userName, userSex, startRow);
    users.forEach(System.out::println);
  }

  @Test
  void testCreatUser() {
    Users user = new Users();
    user.setUserId("25968954638794932");
    user.setCardType("身份证");
    user.setCardNo("110654198804079012");
    user.setUserName("wataxi");
    user.setUserSex("男");
    user.setUserAge("33");
    user.setUserRole("无业游民");
    int count = userService.createUser(user);
    if (count == 1){
      System.out.println("添加成功");
    }
  }

  @Test
  void testDeleteById() {
    int count = userService.deleteUserById("25968954638794932");
    if(count == 1){
      System.out.println("删除成功");
    }
  }
}
