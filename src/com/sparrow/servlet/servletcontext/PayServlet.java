package com.sparrow.servlet.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: 诉衷情の麻雀
 * @Description: TODO
 * @DateTime: 2023/7/1 15:54
 **/
public class PayServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        System.out.println("PayServlet servletContext=" + servletContext + "运行类型=" + servletContext.getClass());

        //从servletContext获取visit_count 属性 k-v
        Object visit_count = servletContext.getAttribute("visit_count");
        //判定visit_count是否为null
        if (visit_count == null) {
            servletContext.setAttribute("visit_count", 1);
            visit_count = 1;
        }else { //是第二次或以后
            //取出visit_count 的属性值+1
            visit_count = Integer.parseInt(visit_count + "") + 1;
            //放回到ServletContext
            servletContext.setAttribute("visit_count" ,visit_count);
        }

        resp.setContentType("text/html;charset=utf-8");
        //输出显示
        PrintWriter writer = resp.getWriter();
        writer.print("<h1>网站被访问次数是" +visit_count + "</h1>");
        writer.flush();
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
