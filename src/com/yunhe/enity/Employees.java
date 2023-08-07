package com.yunhe.enity;

public class Employees {
    private int employeeId;
    private String name;
    private double salary;
    private String hireDate;
    private int departmentId;


    public Employees() {
    }

    public Employees( String name, double salary, String hireDate, int departmentId) {
        this.name = name;
        this.salary = salary;
        this.hireDate = hireDate;
        this.departmentId = departmentId;
    }
    public Employees(int employeeId, String name, double salary, String hireDate, int departmentId) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
        this.hireDate = hireDate;
        this.departmentId = departmentId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
