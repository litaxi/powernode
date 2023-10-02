package com.powernode.pojo;


/**
 * @Author wataxi @Date 2023/9/28 19:41 @Version 1.0
 */
public class Users {
private String username;
private String password;

  public Users(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public Users() {

  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}

