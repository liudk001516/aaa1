package com.yunhe.service;

import com.yunhe.enity.Employees;
import com.yunhe.enity.PageLimit;

import java.util.List;

public interface EmpService {
    /*
    *  查询所有业务
    * */
    public List<Employees> findAll();
    /*
    * 搜索业务
    * */
    List<Employees> findSelect(String name);

    int addEmp(Employees employees);

    int delEmp(String employeeId);

    int updateEmp(Employees employees);

    PageLimit selectLimit(String currentPage, String pageSize);
}
