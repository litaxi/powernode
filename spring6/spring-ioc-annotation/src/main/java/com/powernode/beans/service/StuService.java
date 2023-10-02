package com.powernode.beans.service;

import com.powernode.beans.dao.StuDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author wataxi @Date 2023/9/26 20:24 @Version 1.0
 */
@Service("stuService")
public class StuService {
//  @Resource(name = "stuDao")
  private StuDao stuDao;

  public void saveStuInfo() {
    stuDao.insert();
  }
  @Resource

  public void setStuDao(StuDao stuDao) {
    this.stuDao = stuDao;
  }

  public StuService() {
    System.out.println("service被创建了。。。");
  }
}
