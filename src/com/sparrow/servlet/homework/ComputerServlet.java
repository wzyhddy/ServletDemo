package com.sparrow.servlet.homework;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: 诉衷情の麻雀
 * @Description: TODO
 * @DateTime: 2023/7/1 22:13
 **/
public class ComputerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        System.out.println("computerServlet被调用了");
        //分析http请求头
        String userAgent = req.getHeader("User-Agent");
        String regStr = "\\((.*)\\)";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(userAgent);
        matcher.find();//因为我们的userAgent只有一组()
        String group = matcher.group(0);//windows NT 10.0
        String group1 = matcher.group(1);
        String[] split = group1.split(";");
        System.out.println("操作系统=" + split[0]);
        System.out.println("操作系统位数=" + split[1].trim());//trim去掉左右两边的空格
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
