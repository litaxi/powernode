package com.powernode.user.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author wataxi @Date 2023/10/1 15:05 @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Users {
  private String userId;//用户id
  private String cardType;//证件类型
  private String cardNo;//证件号码
  private String userName;//用户姓名
  private String userSex;//用户性别
  private String userAge;//用户年龄
  private String userRole;//用户角色
}
