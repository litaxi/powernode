package com.powernode.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Author wataxi @Date 2023/10/1 13:15 @Version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    if(request.getSession().getAttribute("uid") == null){
      request.setAttribute("errMsg","请先登录，谢谢！");
      request.getRequestDispatcher("/login.jsp").forward(request,response);
      return false;
    }
    return true;
  }
}
