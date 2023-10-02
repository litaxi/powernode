package com.powernode.mybatis;

import com.powernode.mybatis.mapper.ClazzMapper;
import com.powernode.mybatis.pojo.Clazz;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @Author wataxi
 * @Date 2023/9/24 18:34
 * @Version 1.0
 */
public class ClazzMapperTest {

    /**
     *
     * 二级缓存的范围是SqlSessionFactory。使用二级缓存需要具备以下几个条件:
     * 1.<setting name="cacheEnabled' value="true">全局性地开启或关闭所有映射器配置文件中已配置的任何缓存。默认就是true，无需设置。
     * 2．在需要使用二级缓存的SqlMapper.xml文件中添加配置:<cache />
     * 3．使用二级缓存的实体类对象必须是可序列化的，也就是必须实现java.io.Serializable接口
     * 4. SqlSession对象关闭或提交之后，一级缓存中的数据才会被写入到二级缓存当中。此时二级缓存才可用。
     *
     */


    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectAllStusByCid(1000);
        System.out.println(clazz);

    }
}
