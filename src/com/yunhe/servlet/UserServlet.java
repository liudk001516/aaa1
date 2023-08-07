package com.yunhe.servlet;


import com.yunhe.enity.User;
import com.yunhe.service.UserService;
import com.yunhe.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    UserService userService= new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("login".equals(method)) {
            login(req,resp);
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //调用业务
        User user =userService.login(username,password);

        if (user!=null) {
            //登录成功
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            resp.sendRedirect(req.getContextPath()+"/html/emp_list.html");
        }else{
            //继续登录
            resp.sendRedirect(req.getContextPath()+"/html/login.html");
        }

    }
}
