import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @Author: 诉衷情の麻雀
 * @Description: TODO
 * @DateTime: 2023/6/22 15:35
 **/
public class HelloServlet implements Servlet {

    private int count = 0;

    /**
     * 初始化Servlet
     * 当Tomcat创建HttpServlet实例时，会init方法，
     * 该方法只会被调用一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init()被调用");
    }

    /**
     * 返回ServletConfig的配置，也就是返回Servlet的配置
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法处理浏览器的请求Get/Post
     * 当浏览器每次请求Servlet时，就会调用一次Service
     * 当Tomcat调用该方法时，会把Http请求的数据封装成实现ServletRequest接口的request对象
     * 通过ServletRequest对象，可以得到用户提交的数据
     * servletResponse对象可以用于返回数据给Tomcat->浏览器
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        count++;
        System.out.println("hi servlet");
    }

    /**
     * 返回servlet信息
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 该方法是在servlet被摧毁的时候调用，只会调用一次
     */
    @Override
    public void destroy() {

    }
}
