package cn.itcast.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        ServletContext功能
        1. 获取MIME类型：
            * MIME类型：在互联网通信过程中定义的一种文件数据类型
                * 格式：大类型/小类型 text/html image/jpeg
            * 获取：String getMime
        2. 域对象：共享数据
        3. 获取文件的真实（服务器）路径
         */

        // 2. 通过HttpServlet获取
        ServletContext context = this.getServletContext();
        // 获取文件的服务器路径
        String realPath = context.getRealPath("/b.txt"); // WEB资源下的
        System.out.println(realPath);
//        File file = new File(realPath);
        String c = context.getRealPath("/WEB-INF/c.txt"); // WEB-INF路径
        String a = context.getRealPath("/WEB-INF/classes/a.txt"); // src下资源


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
