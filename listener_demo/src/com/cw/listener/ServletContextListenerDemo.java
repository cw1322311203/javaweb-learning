package com.cw.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author 陈小哥cw
 * @date 2021/1/8 15:41
 * Servlet规范中的8个监听器简介
 * 监听对象创建的
 * ServletContextListener:用于监听ServletContext对象创建和销毁的监听器
 * - contextInitialized:对象创建时执行此方法。该方法的参数是ServletContextEvent事件对象，事件是【创建对象】这个动作
 * 事件对象中封装着触发事件的来源，即事件源，就是ServletContext
 * - contextDestroyed:对象销毁执行此方法
 * HttpSessionListener:用于监听HttpSession对象创建和销毁的监听器
 * - sessionCreated:对象创建时执行此方法。
 * - sessionDestroyed:对象销毁执行此方法
 * ServletRequestListener:用于监听ServletRequest对象创建和销毁的监听器
 * - requestInitialized:对象创建时执行此方法
 * - requestDestroyed:对象销毁执行此方法
 * <p>
 * 监听域中属性发生变化的
 * ServletContextAttributeListener:用于监听ServletContext域（应用域）中属性发生变化的监听器
 * - attributeAdded:域中添加了属性触发此方法。参数是ServletContextAttributeEvent事件对象，事件是【添加属性】。
 * 事件对象中封装着事件源，即ServletContext。
 * 当ServletContext执行setAttribute方法时，此方法可以知道，并执行。
 * - attributeRemoved:域中删除了属性触发此方法
 * - attributeReplaced:域中属性发生改变触发此方法
 * HttpSessionAttributeListener:用于监听HttpSession域（会话域）中属性发生变化的监听器
 * - attributeAdded:域中添加了属性触发此方法
 * - attributeRemoved:域中删除了属性触发此方法
 * - attributeReplaced:域中属性发生改变触发此方法
 * ServletRequestAttributeListener:用于监听ServletRequest域（请求域）中属性发生变化的监听器
 * - attributeAdded:域中添加了属性触发此方法
 * - attributeRemoved:域中删除了属性触发此方法
 * - attributeReplaced:域中属性发生改变触发此方法
 * <p>
 * <p>
 * 和会话相关的两个感知型监听器
 * HttpSessionBinderListener:用于感知对象和和会话域绑定的监听器
 * 当有数据加入会话域或从会话域中移除，此监听器的两个方法会执行。
 * 加入会话域即和会话域绑定,从会话域移除即从会话域解绑
 * - valueBound:当数据加入会话域时，也就是绑定，此方法执行
 * - valueUnbound:当从会话域移除时，也就是解绑，此方法执行
 * <p>
 * HttpSessionActivationListener：用于感知会话域中对象钝化和活化的监听器
 * - sessionWillPassivate:当会话域中的数据钝化时，此方法执行
 * - sessionDidActivate:当会话域中的数据活化时（激活），此方法执行
 */
// TODO 用于监听ServletContext对象创建和销毁的监听
//@WebListener
public class ServletContextListenerDemo implements ServletContextListener {
    /**
     * ServletContext对象创建时执行此方法。该方法的参数是ServletContextEvent事件对象，事件是【创建对象】这个动作
     * 事件对象中封装着触发事件的来源，即事件源，就是ServletContext
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听到了对象的创建...");

        // 获取对象
        ServletContext servletContext = sce.getServletContext();
//        System.out.println(servletContext);

        //添加属性
        servletContext.setAttribute("username", "zhangsan");

        // 替换属性
        servletContext.setAttribute("username", "lisi");

        // 移除属性
        servletContext.removeAttribute("username");
    }

    /**
     * ServletContext对象销毁执行此方法
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("监听到了对象的销毁...");
    }
}
