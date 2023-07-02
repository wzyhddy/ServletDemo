package com.sparrow.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: 诉衷情の麻雀
 * @Description: TODO
 * @DateTime: 2023/7/1 18:52
 **/
public class HttpServletRequestMethods extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //这里我们使用request对象，获取表单提交的各种数据
        System.out.println("HttpServletRequestMethod被调用了...");
        System.out.println("请求的资源路径URI=" + req.getRequestURI());
        System.out.println("请求的统一资源定位符(绝对路径)URL=" + req.getRequestURL());
        System.out.println("请求客户端的IP地址=" + req.getRemoteAddr());
        System.out.println("请求主机地址=" + req.getRemoteHost());
        System.out.println("http请求头=" + req.getHeader("Host"));
        System.out.println("该请求的发起地址是=" + req.getHeader("Referer"));
        String cookies = req.getHeader("Cookie");
        String JSESSIONID = cookies.split("=")[1];
        System.out.println("取出JSESSIONID=" + JSESSIONID);
        String userAgent = req.getHeader("User-Agent");
        //取出
        String[] s = userAgent.split(" ");
        System.out.println("s= " + s[s.length - 1].split("\\/")[0]);
        System.out.println("User-Agent=" + req.getHeader("User-Agent"));
        //1.获取表单的数据【单个数据】
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println("username =" + username);
        System.out.println("pwd=" + pwd);
        //增强for循环
        for (String hobby : hobbies) {
            System.out.println("hobby=" + hobby);
        }

        //返回接收到的信息,给浏览器回显
        //本质就是在http响应头加上Content-Type text/html;charset=utf-8
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("提交的用户名=" + username);
        writer.flush();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
