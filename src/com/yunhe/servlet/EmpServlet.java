package com.yunhe.servlet;

import com.yunhe.enity.Employees;
import com.yunhe.enity.PageLimit;
import com.yunhe.service.EmpService;
import com.yunhe.service.impl.EmpServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/emp")
public class EmpServlet extends HttpServlet {
    EmpService empService= new EmpServiceImpl();
    ObjectMapper mapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");

        if ("findAll".equals(method)) {
            findAll(req,resp);
        }else if("findSelect".equals(method)){
            findSelect(req,resp);
        } else if ("addEmp".equals(method)) {
            addEmp(req,resp);

        }else if ("delEmp".equals(method)){
            delEmp(req,resp);
        }else if ("updateEmp".equals(method)){
            updateEmp(req,resp);
        } else if ("pageFind".equals(method)) {
            pageFind(req,resp);
        }
    }

    private void pageFind(HttpServletRequest req, HttpServletResponse resp) {
        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");
        PageLimit list = empService.selectLimit(currentPage,pageSize);
        try {
            String string = mapper.writeValueAsString(list);
            resp.getWriter().println(string);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateEmp(HttpServletRequest req, HttpServletResponse resp) {
        int employeeId = Integer.valueOf(req.getParameter("employeeId"));
        String name = req.getParameter("name");
        double salary = Double.valueOf(req.getParameter("salary"));
        String hireDate = req.getParameter("hireDate");
        int departmentId = Integer.valueOf(req.getParameter("departmentId"));
        Employees employees = new Employees(employeeId,name, salary, hireDate, departmentId);
        int row = empService.updateEmp(employees);
        try {
            resp.getWriter().println(row);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void delEmp(HttpServletRequest req, HttpServletResponse resp) {
        String employeeId = req.getParameter("employeeId");
        int i = empService.delEmp(employeeId);
        try {
            resp.getWriter().println(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*if (i>0){
            try {

                resp.sendRedirect("/JsonDemo/html/emp_list.html");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }*/
    }

    private void addEmp(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        double salary = Double.valueOf(req.getParameter("salary"));
        String hireDate = req.getParameter("hireDate");
        int departmentId = Integer.valueOf(req.getParameter("departmentId"));
        Employees employees = new Employees(name, salary, hireDate, departmentId);
        int row = empService.addEmp(employees);
        try {
//            String json = mapper.writeValueAsString(row);
            resp.getWriter().println(row);
//            resp.sendRedirect("/JsonDemo/html/emp_list.html");
//            resp.sendRedirect("http://127.0.0.1:5500/Day_0802/html/01_%E5%91%98%E5%B7%A5%E5%90%8E%E5%8F%B0%E7%AE%A1%E7%90%86.html");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void findSelect(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1、接收参数条件
        String name = req.getParameter("name");
        //2、调用业务
        List<Employees>list =empService.findSelect(name);
        //3、将list转出json响应
        String json = mapper.writeValueAsString(list);
        resp.getWriter().println(json);

    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //调用查询所有业务
        List<Employees> list = empService.findAll();

        //将集合转json
        String json = mapper.writeValueAsString(list);
        //响应
        resp.getWriter().println(json);
    }
}
