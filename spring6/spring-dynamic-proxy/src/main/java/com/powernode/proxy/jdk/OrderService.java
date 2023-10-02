package com.powernode.proxy.jdk;

/**
 * @Author wataxi @Date 2023/9/27 8:48 @Version 1.0
 */
public interface OrderService {
  /** 生成订单 */
  void generateOrder();

  /** 出库 */
  void delivery();

  /** 入库 */
  void warehouse();
}
