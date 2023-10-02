package com.powernode.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author wataxi
 * @Date 2023/9/24 13:34
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student implements Serializable { // Student是多的一方
    private Integer sid;
    private String sname;
    private Clazz clazz; // Clazz是一的一方
}

