package com.cw.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 陈小哥cw
 * @date 2021/1/7 16:43
 * 学生登录功能
 */
@WebServlet("/loginStudentServlet")
public class LoginStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 2.判断用户名
        if (username == null || "".equals(username)) {
            // 2.1用户名为空 重定向到登陆页面
            resp.sendRedirect("/stu/login.jsp");
            return;
        }

        // 2.2用户名不为空 将用户名存入到会话域中
        req.getSession().setAttribute("username", username);

        // 3.重定向到首页index.jsp
        resp.sendRedirect("/stu/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
