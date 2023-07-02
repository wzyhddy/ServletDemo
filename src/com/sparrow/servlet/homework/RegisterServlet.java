package com.sparrow.servlet.homework;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: 诉衷情の麻雀
 * @Description: TODO
 * @DateTime: 2023/7/1 21:58
 **/
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        System.out.println("registerServlet被调用");

        String username = req.getParameter("username");
        String pwd1 = req.getParameter("pwd1");
        String pwd2 = req.getParameter("pwd2");
        String[] sports = req.getParameterValues("sport");
        //获取单选框
        String gender = req.getParameter("gender");
        String city = req.getParameter("city");
        String info = req.getParameter("info");
        //返回给浏览器回显
        resp.setContentType("text/html;charset=utf-8");
        //解决乱码方式
//        resp.setCharacterEncoding("utf-8");
//        resp.setHeader("Content-Type","text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("username=" + username + "<br/>");
        writer.print("pwd1=" + pwd1 + "<br/>");
        writer.print("pwd2=" + pwd2 + "<br/>");

    }
}
