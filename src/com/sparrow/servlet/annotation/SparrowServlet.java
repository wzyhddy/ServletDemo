package com.sparrow.servlet.annotation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注解方式来配置
 * @WebServlet 是一个注解 => Java基础 注解
 * urlPattern对应web.xml的<url-pattern></url-pattern>
 * @WebServlet(urlPatterns = {"/s1", "/s2"}) 代替了web.xml配置
 * 浏览器可以这样访问SparrowServlet 可以http://localhost:8080/s1 或/s2来访问
 * 底层使用了反射 +注解+IO+集合来支撑
 * 注解方式开发Servlet和web.xml配置Servlet流程机制是一样的
 * crtl +　alt + ->快捷键
 **/
@WebServlet(urlPatterns = {"/s1", "/s2"})
public class SparrowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("注解方式 doGet被调用了");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("注解方式 doPost被调用了");
    }
}
