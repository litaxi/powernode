package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Student;

import java.util.List;

/**
 * @Author wataxi
 * @Date 2023/9/24 13:34
 * @Version 1.0
 */
public interface StudentMapper {
    Student selectById(Integer sid);

    List<Student> selectStus(Integer cid);
}
