package com.powernode.mybatis.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wataxi
 * @Date 2023/9/21 21:33
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private Long id;
    private String carNum;
    private String brand;
    private Double guidePrice;
    private String produceTime;
    private String carType;
}
