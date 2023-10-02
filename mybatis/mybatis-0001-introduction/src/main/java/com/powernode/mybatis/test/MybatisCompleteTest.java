package com.powernode.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @Author wataxi
 * @Date 2023/9/21 19:55
 * @Version 1.0
 */
public class MybatisCompleteTest {

    //单元测试方法写多少个。
    //一般是一个业务方法对应一个测试方式。
    //测试方法的规范:public void testXxxX()(
    //测试方法的方法名:以test开始。假设测试的方法是sum，这个测试方法名: testSum
    // @Test注解非常重要，被这个注解标注的方法就是一个单元测试方法。

    public static void main(String[] args) {
        SqlSession sqlSession= null;
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsReader("mybatis-config.xml"));
            sqlSession = sqlSessionFactory.openSession();
            int count = sqlSession.insert("insertCar");
            sqlSession.commit();
            System.out.println(count);
        } catch (IOException e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
