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
 * TODO Cookie的禁用
 * 解决浏览器禁用cookie
 * 方式一:通过提示信息告知用户，大部分网站采用的解决方式
 * 方式二:访问时拼接jsessionid标识，通过encodeURL()方法重写地址
 */
@WebServlet("/servletDemo03")
public class ServletDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取HttpSession对象
        HttpSession session = req.getSession(false);
        System.out.println(session);
        if (session == null) {
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().write("为了不影响正常的使用，请不要禁用浏览器的Cookie");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
