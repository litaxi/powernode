package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Clazz;

/**
 * @Author wataxi
 * @Date 2023/9/24 13:34
 * @Version 1.0
 */
public interface ClazzMapper {

    Clazz selectById(Integer cid);
    Clazz selectAllStusByCid(Integer cid);
}
