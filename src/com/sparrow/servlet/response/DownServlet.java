package com.sparrow.servlet.response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: 诉衷情の麻雀
 * @Description: TODO
 * @DateTime: 2023/7/2 10:23
 **/
public class DownServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("downServlet被调用了");
//        resp.setContentType("application/x-tar;charset=utf-8");
//        PrintWriter writer = resp.getWriter();
//        writer.print("hi");
//        writer.flush();
//        writer.close();
        //1.sendRedirect 本质就会返回302 状态码 Location: /downServletNew
//        resp.sendRedirect("/downServletNew");
        //获取application context
        String contextPath = getServletContext().getContextPath();
        System.out.println("contextPath=" + contextPath);
        resp.setStatus(302);
        resp.setHeader("Location", "/downServletNew");
    }
}
