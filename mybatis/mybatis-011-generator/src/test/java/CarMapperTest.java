import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author wataxi
 * @Date 2023/9/24 20:39
 * @Version 1.0
 */
public class CarMapperTest {

    @Test
    public void testDeleteByPrimaryKey(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteByPrimaryKey(5L);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(count);
    }

    /*@Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAll();
        sqlSession.close();
        cars.stream().forEach(System.out::println);
    }*/

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int pageNum = 2;
        int pageSize = 3;
        PageHelper.startPage(pageNum, pageSize);
        List<Car> cars = mapper.selectAll();
        // 获取分页信息对象
        PageInfo<Car> pageInfo = new PageInfo<>(cars, 3);
        sqlSession.close();
        System.out.println(pageInfo);
    }
}
