package com.sparrow.servlet.annotation;

import javax.servlet.annotation.WebServlet;
import java.util.HashMap;

/**
 * @Author: 诉衷情の麻雀
 * 模拟Tomcat是如果通过@WebServlet(urlPatterns = {"/s1","/s2"})
 * 来装载一个Servlet的
 **/
public class TestAnnotationServlet {
    private static final HashMap<String, Object> hashMap= new HashMap<>();


    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //1. 首先要得到扫描的包
        String classAllPath = "com.sparrow.servlet.annotation.SparrowServlet";
        //2.得到OkServlet的Class对象
        Class<?> aClass = Class.forName(classAllPath);
        //3.通过class对象，得到Annotation
        WebServlet annotation = aClass.getAnnotation(WebServlet.class);
        System.out.println(annotation);
        String[] strings = annotation.urlPatterns();
        for (String url : strings) {
            System.out.println("url = " + url);
        }

        //如果匹配url，如果是第一次，tomcat就会创建一个SparrowServlet实例，放入到HashMap中
        //为什么要放入到HashMap中，方便以后再次调用，因为Servlet是单例化的，在内存中只有一份
        Object instance = aClass.newInstance();
        System.out.println("instance" + instance); //SparrowServlet
        //简单的模拟
        hashMap.put("SparrowServlet", instance);
        System.out.println(hashMap);
    }
}
