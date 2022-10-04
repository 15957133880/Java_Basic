package org.example;

import bean.Customer;
import mapper.CustomerMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisDemo_Mapper {
    public static void main(String[] args) throws IOException {
        //1. 加载mybatis的核心配置文件 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象,用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        3. 执行sql
//        List<Customer> customerList = sqlSession.selectList("test.selectAll", 10001);
        //3.1 获取CustomerMapper接口的代理对象
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> customerList = customerMapper.selectAll();

        System.out.println(customerList);

        //4. 释放资源
        sqlSession.close();
    }
}
