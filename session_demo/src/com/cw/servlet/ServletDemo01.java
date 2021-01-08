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
 * 1.HttpSession，它虽然是服务端会话管理技术的对象，但它本质仍是一个Cookie。是一个由服务器自动创建的特殊的Cookie，Cookie的名称就是JSESSIONID，Cookie的值是服务器分配的一个唯一的标识。
 * 2.当我们使用HttpSession时，浏览器在没有禁用Cookie的情况下，都会把这个Cookie带到服务器端，然后根据唯一标识去查找对应的HttpSession对象，找到了，我们就可以直接使用了
 */
@WebServlet("/servletDemo01")
public class ServletDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取请求的用户名
        String username = req.getParameter("username");

        // 2.获取HttpSession的对象
        /**
         * getSession
         * 参数是Boolean类型，表示当没找到指定session后是否自动创建
         * true:自动创建(默认值)
         * false:不自动创建，在调用request.getSession(false),没找到时返回null
         */
        HttpSession session = req.getSession();
        System.out.println("servletDemo01 --> " + session);
        System.out.println("servletDemo01[JSESSIONID] --> " + session.getId());

        // 3.将用户名信息添加到共享资料中
        session.setAttribute("username", username);

        // 实现URL的重写 相当于在地址栏后面拼接了一个jsessionid
        resp.getWriter().write("<a href='" + resp.encodeURL("http://localhost:8080/session/servletDemo03") + "'>go servletDemo03</a>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
