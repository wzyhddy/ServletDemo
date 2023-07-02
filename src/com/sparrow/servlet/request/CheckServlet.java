package com.sparrow.servlet.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: 诉衷情の麻雀
 * @Description: TODO
 * @DateTime: 2023/7/1 21:16
 **/
public class CheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CheckServlet被调用");
        //根据用户名来确定用户是什么身份
       String username =  req.getParameter("username");
        if("tom".equals(username)) {
            req.setAttribute("role", "管理员");
        }else {
            req.setAttribute("role", "普通用户");
        }

        //获取分发器
        //
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/manageServlet");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
