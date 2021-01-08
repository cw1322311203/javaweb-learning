package com.cw.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * @author 陈小哥cw
 * @date 2021/1/8 15:56
 * <p>
 * TODO 监听应用域中属性发生变化的监听器
 */
//@WebListener
public class ServletContextAttributeListenerDemo implements ServletContextAttributeListener {

    /**
     * 域中添加了数据
     */
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("监听到了属性的添加...");

        // 获取应用域对象
        ServletContext servletContext = scae.getServletContext();
        // 获取属性
        Object username = servletContext.getAttribute("username");
        System.out.println(username);
    }

    /**
     * 域中属性发生了替换
     */
    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("监听到了属性的替换...");
        // 获取应用域对象
        ServletContext servletContext = scae.getServletContext();
        // 获取属性
        Object username = servletContext.getAttribute("username");
        System.out.println(username);
    }

    /**
     * 域中移除属性
     */
    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("监听到域中移除了属性...");
        // 获取应用域对象
        ServletContext servletContext = scae.getServletContext();
        // 获取属性
        Object username = servletContext.getAttribute("username");
        System.out.println(username);
    }
}
