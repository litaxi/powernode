package com.powernode.web;

import com.powernode.pojo.Users;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author wataxi @Date 2023/9/28 12:51 @Version 1.0
 */
@Controller
public class AdminAction {

  @RequestMapping("/index")
  public String index() {
    return "login";
  }

  @RequestMapping("/login")
  public String login(Users users, HttpServletRequest request) {
    if ("张三".equals(users.getUsername()) && "123456".equals(users.getPassword())) {
      request.setAttribute("uid", 1);
      return "main";
    } else {
      request.setAttribute("errMsg", "密码错误，请重新登录，谢谢！");
      return "login";
    }
  }
}
