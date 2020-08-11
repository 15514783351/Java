package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示Request对象获取请求行数据
 */

@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1. 获取请求方式 Get   String getMethod()
         * 2. 获取虚拟目录 /day14 getContextPath()
         * 3. 获取Servlet路径 /demo1 String getServletPath
         * 4. 获取get方式请求参数 name=zhangsan String getQueryString()
         * 5。 获取请求URL  String getRequestURI() StringBuffer getRequestURL
         * URL:统一资源定位符  http://localhost/RequestDemo1
         * URI：统一资源标识符 /RequestDemo1  范围更大
         * 6. 获取协议及版本 String getProtocol()
         * 7. 获取客户机的ip地址 String getRemoteAddr()
         */

        // 1. 获取请求方式 Get   String getMethod()
        String method = request.getMethod();
        System.out.println(method);
        // 2. 获取虚拟目录 /day14 getContextPath()
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        // 3. 获取Servlet路径 /demo1 String getServletPath
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        // 4. 获取get方式请求参数 name=zhangsan String getQueryString()
        String queryString = request.getQueryString();
        System.out.println(queryString);
        // 5. 获取请求URL  String getRequestURI() StringBuffer getRequestURL
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);
        // 6. 获取协议及版本 String getProtocol()
        String protocol = request.getProtocol();
        System.out.println(protocol);
        // 7. 获取客户机的ip地址 String getRemoteAddr()
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
    }
}
