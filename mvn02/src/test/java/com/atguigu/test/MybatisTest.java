package com.atguigu.test;

import com.atguigu.dao.EmployeeDao;
import com.atguigu.domain.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void test() throws IOException {
        //1读取配置文件
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            Employee employee = openSession.selectOne("com.atguigu.dao.Employee.findAll", 1);
            System.out.println(employee.toString());
        }
            finally {
            openSession.close();
        }



    }
}
