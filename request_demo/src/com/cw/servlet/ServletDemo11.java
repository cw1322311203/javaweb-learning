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
 * TODO 请求包含
 * 它是把两个Servlet的响应内容合并输出。
 * 注意：这种包含是动态包含。
 * 动态包含的特点：各编译各的，只是最后合并输出。
 * 请求包含的注意事项：被包含者的响应消息头丢失。因为它被包含起来了。
 */
@WebServlet("/servletDemo11")
public class ServletDemo11 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servletDemo11 running...");

        // 获取请求调度对象
        RequestDispatcher rd = req.getRequestDispatcher("/servletDemo12");
        // 实现包含功能
        rd.include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
