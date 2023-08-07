package com.yunhe.filter;

import com.yunhe.enity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/*@WebFilter("/*")*/
public class FilterEncoding implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //解决post请求乱码
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        /*  response.setContentType("text/html;charset=utf-8");*/
        request.setCharacterEncoding("UTF-8");
        //响应乱码

        //判断路径是否需要拦截  不包括协议和端口的路径
        String uri = request.getRequestURI();
        String method = request.getParameter("method");

        ArrayList<String> list = new ArrayList<>();
        list.add("login.html");
        //需要放行的路径 //day19_emp/user
        list.add("user");
        list.add("index.jsp");

        for (String url : list) {
            if (uri.contains(url)) {
                //不需要拦截的路径
                filterChain.doFilter(request,response);
                return;
            }
        }

        //需要拦截的路径
        //
        User user = (User) request.getSession().getAttribute("user");

        if (user!=null) {
            //已经登录了
            //放行
           filterChain.doFilter(request,response);
        }else{
            response.setContentType("text/html;charset=utf-8");
            //5秒后跳转到登录页面
            response.getWriter().println("小老弟你没有权限操作,请登录后重试！");
            response.setHeader("refresh","2;url=/JsonDemo/html/login.html");
        }

    }

    @Override
    public void destroy() {

    }
}
