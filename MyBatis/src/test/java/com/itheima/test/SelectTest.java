package com.itheima.test;

import bean.Customer;
import mapper.CustomerMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectTest {
    @Test
    public void testSelectAll() throws IOException {
        int id = 10001;
        String cust_name = "liu";
        String cust_state = "M";
        cust_name = "%liu%";
        cust_state = "%M%";

        //1. 加载mybatis的核心配置文件 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象,用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.1 获取CustomerMapper接口的代理对象
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        //4. 执行方法
//        List<Customer> customerList = customerMapper.selectAll();
//        Customer customer = customerMapper.selectByCustId(id);
        Customer customer = customerMapper.selectByCustId(id);

        sqlSession.close();
    }

    @Test
    public void testByCustId() throws IOException {
        int id = 10001;
        String cust_name = "liu";
        String cust_state = "M";
        cust_name = "%liu%";
        cust_state = "%M%";

        //1. 加载mybatis的核心配置文件 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象,用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.1 获取CustomerMapper接口的代理对象
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        //4. 执行方法
        Customer customer = customerMapper.selectByCustId(id);

        //5. 释放资源
        sqlSession.close();
    }

    //多条件动态t选择一个单条件查询
    @Test
    public void testByCondition() throws IOException {
        //接受参数
        int id = 10001;
        String cust_name = "liu";
        String cust_state = "M";

        //处理参数
        cust_name = "%" + cust_name + "%";
        cust_state = "%" + cust_state + "%";

        //封装对象
        Customer customer1 = new Customer();
        customer1.setCust_name(cust_name);
        customer1.setCust_state(cust_state);

        Map map = new HashMap();
//        map.put("cust_name", cust_name);
        map.put("cust_state", cust_state);

        //1. 加载mybatis的核心配置文件 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象,用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.1 获取CustomerMapper接口的代理对象
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        //4. 执行方法
//        List<Customer> customerList = customerMapper.selectByCondition(cust_name, cust_state);
//        List<Customer> customerList = customerMapper.selectByCondition(customer1);
        List<Customer> customerList = customerMapper.selectByCondition(map);

        //5. 释放资源
        sqlSession.close();
    }

    @Test
    //从多个条件中动态选择一个查询
    public void testBySingleCondition() throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //接受参数
        int id = 10001;
        String cust_name = "liu";
        String cust_state = "M";

        //处理参数
        cust_name = "%" + cust_name + "%";
        cust_state = "%" + cust_state + "%";

        //封装对象
        Customer customer1 = new Customer();
        customer1.setCust_name(cust_name);
//        customer1.setCust_state(cust_state);

        Map map = new HashMap();
        map.put("cust_name", cust_name);
//        map.put("cust_state", cust_state);

        //1. 加载mybatis的核心配置文件 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象,用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.1 获取CustomerMapper接口的代理对象
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        //4. 执行方法
//        List<Customer> customerList = customerMapper.selectByCondition(cust_name, cust_state);
        List<Customer> customerList = customerMapper.selectBySingleCondition(customer1);
//        List<Customer> customerList = customerMapper.selectByCondition(map);

        //5. 释放资源
        sqlSession.close();
    }


}
