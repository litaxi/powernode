package com.powernode.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @Author wataxi
 * @Date 2023/9/21 20:45
 * @Version 1.0
 */
public class SqlSessionUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private SqlSessionUtil() {
    }

    public static SqlSession openSqlSession() {
        return sqlSessionFactory.openSession();
    }

    public static void closeSqlSession(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    public static void commitSqlSession(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.commit();
        }
    }
}
