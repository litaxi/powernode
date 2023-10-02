package com.powernode.mybatis.test;

import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author wataxi
 * @Date 2023/9/21 20:15
 * @Version 1.0
 */
public class CarMapperTest {

    @Test
    public void testInsertCarByUtil(){
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        int count = sqlSession.insert("insertCar");
        System.out.println(count);
        SqlSessionUtil.commitSqlSession(sqlSession);
        sqlSession.close();
    }

    @Test
    public void testInsertCar(){
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
