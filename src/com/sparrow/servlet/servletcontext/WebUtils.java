package com.sparrow.servlet.servletcontext;

import javax.servlet.ServletContext;

/**
 * @Author: 诉衷情の麻雀
 * @Description: TODO
 * @DateTime: 2023/7/1 16:15
 **/
public class WebUtils {
    public static Integer visitCount(ServletContext servletContext){

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
        return Integer.parseInt( visit_count +"");
    }

}
