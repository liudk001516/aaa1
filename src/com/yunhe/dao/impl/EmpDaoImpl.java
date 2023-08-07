package com.yunhe.dao.impl;

import com.yunhe.dao.EmpDao;
import com.yunhe.enity.Employees;
import com.yunhe.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class EmpDaoImpl implements EmpDao {

    QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());

    @Override
    public List<Employees> findAllEmployees() {
        String sql = "select * from employees";

        try {
            return qr.query(sql, new BeanListHandler<Employees>(Employees.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Employees> findBySelect(String name) {

        String sql = "select * from employees where name like ?";


        try {
            return  qr.query(sql, new BeanListHandler<Employees>(Employees.class), "%" + name + "%");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int insertOne(Employees e) {
        try {
            return qr.update("insert into employees values (null,?,?,?,?)",e.getName(),e.getSalary(),e.getHireDate(),e.getDepartmentId());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public int deleteOneById(String employeeId) {
        try {
            return qr.update("delete from employees where employeeId =?",employeeId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateOneByEmployeeId(Employees e) {
        try {
            return qr.update("update employees set name=?,salary=?,hireDate=?,departmentId=? where employeeId=?",e.getName(),e.getSalary(),e.getHireDate(),e.getDepartmentId(),e.getEmployeeId());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Employees> findByLimit(int cPage, int pSize) {
        try {
            return qr.query("select * from employees limit ?,?",new BeanListHandler<Employees>(Employees.class),cPage,pSize);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
