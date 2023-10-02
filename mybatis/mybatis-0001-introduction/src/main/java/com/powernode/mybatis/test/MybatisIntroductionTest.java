package com.powernode.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author wataxi
 * @Date 2023/9/21 19:14
 * @Version 1.0
 */
public class MybatisIntroductionTest {
    public static void main(String[] args) throws IOException {
        //创建SQLSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //InputStream is2 = ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");
        //获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行Sql语句
        int count = sqlSession.insert("insertCar");
        sqlSession.commit();
        System.out.println("插入了几条数据：" + count);
    }
}
