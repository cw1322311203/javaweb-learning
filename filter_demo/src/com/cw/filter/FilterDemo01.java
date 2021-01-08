package com.cw.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author 陈小哥cw
 * @date 2021/1/8 14:02
 *
 * 使用web.xml配置过滤器
 * <filter>
 *     <filter-name>FilterDemo01</filter-name>
 *     <filter-class>com.cw.filter.FilterDemo01</filter-class>
 * </filter>
 * <filter-mapping>
 *     <filter-name>FilterDemo01</filter-name>
 *     <url-pattern>/*</url-pattern>
 * </filter-mapping>
 */
//@WebFilter("/*")
public class FilterDemo01 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filterDemo01执行了...");

        // 处理乱码
        servletResponse.setContentType("text/html;charset=UTF-8");

        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
