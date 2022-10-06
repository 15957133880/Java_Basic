package http.test;

import bean.Customer;
import mapper.CustomerMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UpdateTest {
    //添加一箱数据
    @Test
    public void testUpdate() throws IOException {
        String custName = "liu6";
        String custState = "UK";
        int cust_id = 10013;

        Customer customer = new Customer();
        customer.setCust_name(custName);
//        customer.setCust_state(custState);
        customer.setCust_id(cust_id);
        //1. 加载mybatis的核心配置文件 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象,用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.1 获取CustomerMapper接口的代理对象
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        //4. 执行方法
        customerMapper.update(customer);

        //提交事务
        sqlSession.commit();;

        //5. 释放资源
        sqlSession.close();
    }
}
