package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo1.....");
//        // 访问这个资源会自动跳转到Demo2
//        //1. 设置状态码为302
//        response.setStatus(302);
//        // 2. 设置相应头locaation
//        response.setHeader("location", "/day15/responseDemo2");


        // 动态获取虚拟目录
        String contextPath = request.getContextPath();
        // 简单的重定向方法
        response.sendRedirect(contextPath + "/responseDemo2");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
