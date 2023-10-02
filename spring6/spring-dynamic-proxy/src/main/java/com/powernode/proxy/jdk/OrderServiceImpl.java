package com.powernode.proxy.jdk;

/**
 * @Author wataxi @Date 2023/9/27 8:49 @Version 1.0
 */
public class OrderServiceImpl implements OrderService {

  /** 生成订单 */
  @Override
  public void generateOrder() {
    try {
      Thread.sleep(456);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("正在生成订单");
  }

  /** 出库 */
  @Override
  public void delivery() {
    try {
      Thread.sleep(238);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("正在出库");
  }

  /** 入库 */
  @Override
  public void warehouse() {
    try {
      Thread.sleep(345);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("正在出库");
  }
}
