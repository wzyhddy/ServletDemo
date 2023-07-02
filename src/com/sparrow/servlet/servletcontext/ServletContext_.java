package com.sparrow.servlet.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: 诉衷情の麻雀
 * @Description: TODO
 * @DateTime: 2023/7/1 15:31
 **/
public class ServletContext_ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取web.xml的context-parameter

        //1.获取到ServletContext对象
        ServletContext servletContext = getServletContext();
        //2.获取website
        String website = servletContext.getInitParameter("website");
        String company = servletContext.getInitParameter("company");
        //3.获取项目的路径
        String realPath = servletContext.getRealPath("/");
        System.out.println("项目发布后的相对路径=" + realPath);
        System.out.println("website= " + website);
        System.out.println("company=" + company);
    }
}
