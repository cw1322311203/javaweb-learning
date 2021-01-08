package com.cw.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 陈小哥cw
 * @date 2021/1/5 15:24
 * <p>
 * Servlet线程安全问题
 * 启动两个浏览器，输入不同的参数，访问之后发现输出的结果都是一样，所以出现线程安全问题
 * 1.将成员变量变为局部变量
 * 2.使用同步代码块将可能会出问题的地方围上
 */
public class ServletDemo05 extends HttpServlet {

    // 1.定义一个用户名的成员变量
    private String username;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = null;

        synchronized (this) {
            // 2.获取用户名
            username = req.getParameter("username");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 3.将用户名响应给浏览器
            PrintWriter pw = resp.getWriter();
            pw.println("Welcome:" + username);
            pw.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
