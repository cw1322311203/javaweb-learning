package com.cw.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 陈小哥cw
 * @date 2021/1/6 16:41
 * <p>
 * TODO 请求转发
 * 重定向特点：两次请求，浏览器行为，地址栏改变，请求域中的数据会丢失
 * 请求转发：一次请求，服务器行为，地址栏不变，请求域中的数据不丢失
 * <p>
 * 请求域的作用范围：当前请求（一次请求）,和当前请求的转发之中
 *
 * 请求转发的注意事项：负责转发的Servlet，转发前后的响应正文丢失，由转发目的地来响应浏览器。
 */
@WebServlet("/servletDemo09")
public class ServletDemo09 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置共享数据
        req.setAttribute("encoding","gbk");

        // 获取请求调度对象
        RequestDispatcher rd = req.getRequestDispatcher("/servletDemo10");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
