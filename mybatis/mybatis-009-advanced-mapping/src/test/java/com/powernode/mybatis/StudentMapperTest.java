package com.powernode.mybatis;

import com.powernode.mybatis.mapper.StudentMapper;
import com.powernode.mybatis.pojo.Student;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @Author wataxi
 * @Date 2023/9/24 17:44
 * @Version 1.0
 */
public class StudentMapperTest {

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectById(5);
        System.out.println(student);
        sqlSession.close();
    }
}
