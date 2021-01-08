package com.cw.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 陈小哥cw
 * @date 2021/1/8 16:14
 * TODO 检查登录
 */
@WebFilter(value = {"/addStudent.jsp", "/listStudentServlet"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1.将请求和响应对象转换为和HTTP协议相关
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 2.获取会话域对象中数据
        Object username = request.getSession().getAttribute("username");

        // 3.判断用户名
        if (username == null || "".equals(username)) {
            // 重定向到登录界面
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        // 4.放行
        filterChain.doFilter(request, response);
    }
}
