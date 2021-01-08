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
 * @date 2021/1/7 13:36
 * <p>
 * TODO Cookie访问路径限制
 * 默认路径:取自第一次访问的资源路径前缀
 * 只要以这个前缀为开头(包括子级路径)，就能获取到，反之获取不到
 * 可以获取
 * /servlet/servletDemo03
 * /servlet/aaa/servletDemo04
 * 无法获取
 * /bbb/servletDemo05
 * <p>
 * 设置路径:setPath()方法设置指定路径
 */
@WebServlet("/servlet/servletDemo02")
public class ServletDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建Cookie并添加
        Cookie cookie = new Cookie("username", "zhangsan");
        cookie.setMaxAge(3600);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
