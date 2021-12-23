package com.atguigu.dao;

import com.atguigu.domain.Employee;

import java.util.List;

public interface IUserDao {
    List<Employee> findAll();
}
