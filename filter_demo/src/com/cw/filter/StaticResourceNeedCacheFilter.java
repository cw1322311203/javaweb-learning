package com.cw.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 陈小哥cw
 * @date 2021/1/8 14:51
 * <p>
 * TODO 静态资源设置缓存时间过滤器
 * html设置为1小时
 * js设置为2小时
 * css设置为3小时
 */
public class StaticResourceNeedCacheFilter implements Filter {
    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }


    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        //1.把doFilter的请求和响应对象转换成跟http协议有关的对象
        HttpServletRequest request;
        HttpServletResponse response;
        try {
            request = (HttpServletRequest) req;
            response = (HttpServletResponse) res;
        } catch (ClassCastException e) {
            throw new ServletException("non-HTTP request or response");
        }
        //2.获取请求资源URI
        String uri = request.getRequestURI();
        //3.得到请求资源到底是什么类型
        String extend = uri.substring(uri.lastIndexOf(".") + 1);//我们只需要判断它是不是html,css,js。其他的不管
        //4.判断到底是什么类型的资源
        long time = 60 * 60 * 1000;
        if ("html".equals(extend)) {
            //html 缓存1小时
            String html = filterConfig.getInitParameter("html");
            time = time * Long.parseLong(html);
        } else if ("js".equals(extend)) {
            //js 缓存2小时
            String js = filterConfig.getInitParameter("js");
            time = time * Long.parseLong(js);
        } else if ("css".equals(extend)) {
            //css 缓存3小时
            String css = filterConfig.getInitParameter("css");
            time = time * Long.parseLong(css);

        }
        //5.设置响应消息头
        response.setDateHeader("Expires", System.currentTimeMillis() + time);
        //6.放行
        chain.doFilter(request, response);
    }


    public void destroy() {

    }
}
