package com.cw.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 陈小哥cw
 * @date 2021/1/8 14:10
 */
//@WebFilter("/*")
public class FilterDemo03 implements Filter {

    /*
        初始化方法
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("对象初始化成功...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filterDemo03执行了...");

        // 处理乱码
        servletResponse.setContentType("text/html;charset=UTF-8");

        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /*
        对象销毁
     */
    @Override
    public void destroy() {
        System.out.println("对象销毁了...");
    }
}
