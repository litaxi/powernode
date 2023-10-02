package com.powernode.beans.dao.impl;

import com.powernode.beans.dao.StuDao;
import org.springframework.stereotype.Repository;

/**
 * @Author wataxi @Date 2023/9/26 20:23 @Version 1.0
 */
@Repository(value = "stuDao")
public class StuDaoImpl implements StuDao {

  public StuDaoImpl() {
    System.out.println("dao被创建了");
  }

  @Override
  public int insert() {
    System.out.println("MySql数据库正在保存学生信息");
    return 0;
  }
}
