package com.cw.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 陈小哥cw
 * @date 2021/1/7 9:09
 * <p>
 * TODO 重定向
 * 重定向的特点：
 * 两次请求，地址栏改变,请求域对象中不能共享数据，可以重定向到其他服务器，浏览器行为，xxxx
 */
@WebServlet("/servletDemo07")
public class ServletDemo07 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servletDemo07 running...");

        // 设置请求域共享数据
        req.setAttribute("username", "zhangsan");

        // 重定向实现原理
        //1.设置响应状态码
        // response.setStatus(302);
        //2.定向到哪里去: 其实就是设置响应消息头，Location
        // response.setHeader("Location", "ResponseDemo7");

        //使用重定向方法
        resp.sendRedirect(req.getContextPath() + "/servletDemo08");//此行做了什么事，请看上面
        //resp.sendRedirect("https://www.baidu.com/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
