package com.cw.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 陈小哥cw
 * @date 2021/1/8 14:10
 */
//@WebFilter("/*")
public class FilterDemo02 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filterDemo02执行了...");

        // 处理乱码
        servletResponse.setContentType("text/html;charset=UTF-8");

        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
