package com.cw.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 陈小哥cw
 * @date 2021/1/7 14:20
 * TODO session的基本使用
 */
@WebServlet("/servletDemo02")
public class ServletDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取HttpSession对象
        HttpSession session = req.getSession();

        // 2.获取共享数据
        Object username = session.getAttribute("username");
        System.out.println("servletDemo02-->"+session);
        System.out.println("servletDemo02[JSESSIONID] --> "+session.getId());

        // 3.将数据响应到浏览器
        resp.getWriter().write(username + "");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
