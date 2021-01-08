package com.cw.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author 陈小哥cw
 * @date 2021/1/8 14:10
 * <p>
 * TODO 过滤器配置对象的使用
 */
public class FilterDemo04 implements Filter {

    /*
        初始化方法
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("对象初始化成功...");

        // 获取过滤器名称
        String filterName = filterConfig.getFilterName();
        System.out.println(filterName);

        // 根据name获取value
        String username = filterConfig.getInitParameter("username");
        System.out.println(username);

        // 获取过滤器初始化参数名称的枚举
        Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String initName = initParameterNames.nextElement();
            String initValue = filterConfig.getInitParameter(initName);
            System.out.println(initName + "," + initValue);
        }

        //获取ServletContext对象
        ServletContext servletContext = filterConfig.getServletContext();
        System.out.println(servletContext);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filterDemo04执行了...");

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
