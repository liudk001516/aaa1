package com.yunhe.dao;

import com.yunhe.enity.Employees;

import java.util.List;

public interface EmpDao {

    public List<Employees> findAllEmployees();

    List<Employees> findBySelect(String name);

    int insertOne(Employees employees);

    int deleteOneById(String employeeId);

    int updateOneByEmployeeId(Employees employees);

    List<Employees> findByLimit(int cPage, int pSize);
}
