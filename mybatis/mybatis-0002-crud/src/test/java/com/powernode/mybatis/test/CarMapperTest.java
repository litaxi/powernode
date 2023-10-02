package com.powernode.mybatis.test;

import com.powernode.mybatis.pojos.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wataxi
 * @Date 2023/9/21 21:07
 * @Version 1.0
 */
public class CarMapperTest {


    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        List<Car> carList = sqlSession.selectList("selectAll");
        //System.out.println(carList);
        carList.forEach(System.out::println);
        SqlSessionUtil.closeSqlSession(sqlSession);
    }

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        Car car = sqlSession.selectOne("selectById", 1L);
        System.out.println(car);
        SqlSessionUtil.closeSqlSession(sqlSession);
    }

    @Test
    public void testUpdateById(){
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        Car car = new Car(3L, "1688", "吉利666", 15.0, "2015-12-10", "新能源");
        int count = sqlSession.update("updateById", car);
        System.out.println(count);
        SqlSessionUtil.commitSqlSession(sqlSession);
        SqlSessionUtil.closeSqlSession(sqlSession);
    }

    @Test
    public void testInsertCarByPOJO(){
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        Car car = new Car();
        car.setCarNum("4444");
        car.setBrand("保时捷");
        car.setGuidePrice(88.0);
        car.setProduceTime("2016-11-11");
        car.setCarType("超跑车");
        int count = sqlSession.insert("insertCar", car);
        System.out.println(count);
        SqlSessionUtil.commitSqlSession(sqlSession);
        SqlSessionUtil.closeSqlSession(sqlSession);
    }
    @Test
    public void testDeleteById(){
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        int count = sqlSession.delete("deleteById", 13);
        System.out.println(count);
        SqlSessionUtil.commitSqlSession(sqlSession);
        SqlSessionUtil.closeSqlSession(sqlSession);
    }

    @Test
    public void testInsertCarByMap(){
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        Map<String, Object> carMap = new HashMap<String, Object>();
        carMap.put("carNum","888");
        carMap.put("brand","宝马732");
        carMap.put("guidePrice", 12.0);
        carMap.put("produceTime","2021-11-11");
        carMap.put("carType","电车");
        sqlSession.insert("insertCar", carMap);
        SqlSessionUtil.commitSqlSession(sqlSession);
        SqlSessionUtil.closeSqlSession(sqlSession);
    }
}
