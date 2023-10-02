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
    private static ThreadLocal<SqlSession> local = new ThreadLocal<>();

    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private SqlSessionUtil() {
    }


    public static SqlSession openSession() {
        SqlSession sqlSession = local.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            local.set(sqlSession);
        }
        return sqlSession;
    }

    public static void close(SqlSession sqlSession) {
        if (sqlSession != null) {
            local.remove();
            sqlSession.close();
        }
    }

    public static void commit(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.commit();
        }
    }
    public static void rollback(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.rollback();
        }
    }
}
