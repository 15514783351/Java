package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/*
分析
    1. 可以采用Cookie来完成
    2. 在服务器中的servlet判断是否由一个名为lastTime的Cookie
        1. 有：不是第一次访问
            1. 响应数据：欢迎回来，您上次访问时间为：lastTime=2018年6月10如11：50：01
            2. 写回Cookie：lastTime=2018年6月10如11：50：01
        2. 没有：是第一次访问
            1. 响应数据：您好，欢迎您首次访问
            2. 写回Cookie：lastTime=2018年6月10如11：50：01
 */

@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应的消息体的数据格式以及编码
        response.setContentType("text/html;charset=utf-8");
        // 1. 获取所有的cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;  //没有cookie为lastTime
        // 2. 遍历cookie数组
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                // 3. 获取cookie的名称
                String name = cookie.getName();
                //4. 判断名称是否是：lastTime
                if ("lastTime".equals(name)) {
                    // 有这个cookie
                    flag = true;

                    // 响应数据
                    // 获取cookie的value：时间
                    String value = cookie.getValue();
                    // URl解码
                    value = URLDecoder.decode(value, "utf-8");
                    response.getWriter().write("<h1>欢迎回来，您上次访问的时间为：" + value + "</h1>");

                    // 设置cookie的value
                    // 获取当前时间的字符串，重新设置cookie的值，重新发送cookie
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String strDate = sdf.format(date);
                    // URL编码
                    strDate = URLEncoder.encode(strDate, "utf-8");
                    cookie.setValue(strDate);
                    // 设置cookie的存活时间
                    cookie.setMaxAge(60 * 60 * 24 * 30); // 一个月

                    response.addCookie(cookie);

                    break;
                }
            }
        }

        if (cookies == null || cookies.length == 0 || flag == false) {
            // 没有第一次访问
            response.getWriter().write("<h1>第一次访问</h1>");
            // 设置cookie的value
            // 获取当前时间的字符串，重新设置cookie的值，重新发送cookie
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String strDate = sdf.format(date);

            Cookie cookie = new Cookie("lastTime", strDate);
            strDate = URLEncoder.encode(strDate, "utf-8");
            cookie.setValue(strDate);
            // 设置cookie的存活时间
            cookie.setMaxAge(60 * 60 * 24 * 30); // 一个月

            response.addCookie(cookie);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
