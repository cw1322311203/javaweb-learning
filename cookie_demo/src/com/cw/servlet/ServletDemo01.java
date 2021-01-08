package com.cw.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 陈小哥cw
 * @date 2021/1/7 10:47
 * <p>
 * TODO Cookie使用
 * 在JavaEE的项目中，会话管理分为两类。分别是：客户端会话管理技术和服务端会话管理技术。
 * 1.客户端会话管理技术：它是把要共享的数据保存到了客户端（也就是浏览器端）。每次请求时，把会话信息带到服务器，从而实现多次请求的数据共享。
 * 2.服务端会话管理技术：它本质仍是采用客户端会话管理技术，只不过保存到客户端的是一个特殊的标识，并且把要共享的数据保存到了服务端的内存对象中。每次请求时，把这个标识带到服务器端，然后使用这个标识，找到对应的内存空间，从而实现数据共享。
 * 这里的会话，指的是web开发中的一次通话过程，当打开浏览器，访问网站地址后，会话开始，当关闭浏览器（或者到了过期时间），会话结束。
 * <p>
 * TODO Cookie介绍
 * 1.它是客户端浏览器的缓存文件，里面记录了客户浏览器访问网站的一些内容。同时，也是HTTP协议请求和响应消息头的一部分（在HTTP协议课程中，我们备注了它很重要）。
 * 2.它可以保存客户浏览器访问网站的相关内容（需要客户端不禁用Cookie）。从而在每次访问需要同一个内容时，先从本地缓存获取，使资源共享，提高效率。
 * 3.Cookie有大小，个数限制。每个网站最多只能存20个cookie，且大小不能超过4kb。同时，所有网站的cookie总数不超过300个。
 * 4.当删除Cookie时，设置maxAge值为0。当不设置maxAge时，使用的是浏览器的内存，当关闭浏览器之后，cookie将丢失。设置了此值，就会保存成缓存文件（值必须是大于0的,以秒为单位）。
 * - 负整数:当前会话有效，浏览器关闭则清除
 * - 0:立即清除
 * - 正整数:以秒为单位设置存活时间
 * 5.Cookie的名称只能包含ASCCI码表中的字母，数字字符。不能包含逗号，分号，空格，不能以$开头
 * 6.Cookie的值不支持中文
 */
@WebServlet("/servletDemo01")
public class ServletDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.通过响应对象写出提示信息
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.write("欢迎访问本网站，您的最后访问时间为:<br>");

        // 2.创建Cookie对象，用于记录最后访问时间
        Cookie cookie = new Cookie("time", System.currentTimeMillis() + "");

        // 3.设置最大存活时间(单位s)
        /**
         * 存活时间限制setMaxAge()方法接收数字
         * - 负整数:当前会话有效，浏览器关闭则清除
         * - 0:立即清除
         * - 正整数:以秒为单位设置存活时间
         */
        cookie.setMaxAge(3600);

        // 4.将cookie对象添加到客户端
        resp.addCookie(cookie);

        // 5.获取cookie
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie1 : cookies) {
            if ("time".equals(cookie1.getName())) {
                // 6.获取cookie对象中的Value，进行写出
                String value = cookie1.getValue();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                pw.write(sdf.format(new Date(Long.parseLong(value))));
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
