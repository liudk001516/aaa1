package com.yunhe.service.impl;

import com.yunhe.dao.EmpDao;
import com.yunhe.dao.impl.EmpDaoImpl;
import com.yunhe.enity.Employees;
import com.yunhe.enity.PageLimit;
import com.yunhe.service.EmpService;

import java.util.List;

public class EmpServiceImpl implements EmpService {

    EmpDao empDao =new EmpDaoImpl();

    @Override
    public List<Employees> findAll() {
        return empDao.findAllEmployees();
    }

    @Override
    public List<Employees> findSelect(String name) {

        return empDao.findBySelect(name);
    }

    @Override
    public int addEmp(Employees employees) {
        return empDao.insertOne(employees);
    }

    @Override
    public int delEmp(String employeeId) {
        return empDao.deleteOneById(employeeId);
    }

    @Override
    public int updateEmp(Employees employees) {
        return empDao.updateOneByEmployeeId(employees);
    }

    @Override
    public PageLimit selectLimit(String currentPage, String pageSize) {
        int cPage = Integer.valueOf(currentPage);
        int pSize = Integer.valueOf(pageSize);
        PageLimit pageLimit = new PageLimit();
        List<Employees> allEmployees = empDao.findAllEmployees();
        int num = allEmployees.size();
        List<Employees> empLimit= empDao.findByLimit(cPage,pSize);
        pageLimit.setCurrentPage(cPage);
        pageLimit.setPageSize(pSize);
        pageLimit.setList(empLimit);
        pageLimit.setTotal(num);
        return pageLimit;
    }
}
