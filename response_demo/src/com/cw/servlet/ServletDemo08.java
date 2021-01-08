package com.cw.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 陈小哥cw
 * @date 2021/1/7 9:14
 * <p>
 * TODO 重定向
 * 重定向的特点：
 * 两次请求，地址栏改变,请求域对象中不能共享数据，可以重定向到其他服务器，浏览器行为，xxxx
 */
@WebServlet("/servletDemo08")
public class ServletDemo08 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servletDemo08 running...");

        // 获取请求域共享数据
        Object username = req.getAttribute("username");
        System.out.println("username = " + username);// 这里为null。因为响应请求域对象中不能共享数据
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
