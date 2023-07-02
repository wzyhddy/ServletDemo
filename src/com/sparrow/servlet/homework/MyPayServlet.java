package com.sparrow.servlet.homework;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: 诉衷情の麻雀
 * @Description: TODO
 * @DateTime: 2023/7/2 10:55
 **/
public class MyPayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MyPayServlet被调用了");
        resp.setContentType("text/html;charset=utf-8");
        String money = req.getParameter("money");
        int parseInt = Integer.parseInt(money + "");
        if(parseInt > 100){
            resp.sendRedirect("/payok.html");
        }else {
            resp.sendRedirect("/pay.html");
        }
    }
}
