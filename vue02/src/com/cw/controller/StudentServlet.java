package com.cw.controller;

import com.cw.bean.Student;
import com.cw.service.StudentService;
import com.cw.service.impl.StudentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author 陈小哥cw
 * @date 2021/1/12 15:28
 */
@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {

    private StudentService service = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String method = req.getParameter("method");
        if (method.equals("selectByPage")) {
            // 分页查询功能
            selectByPage(req, resp);
        } else if (method.equals("addStu")) {
            // 添加数据功能
            addStu(req, resp);
        } else if (method.equals("updateStu")) {
            // 修改数据功能
            updateStu(req, resp);
        } else if (method.equals("deleteStu")) {
            // 删除数据功能
            deleteStu(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /*
        分页查询功能
     */
    private void selectByPage(HttpServletRequest req, HttpServletResponse resp) {
        // 获取请求参数
        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");

        // 调用业务层的查询方法
        Page page = service.selectByPage(Integer.parseInt(currentPage), Integer.parseInt(pageSize));

        // 封装PageInfo对象
        PageInfo info = new PageInfo(page);

        // 将info转成json，响应给客户端
        try {
            String json = new ObjectMapper().writeValueAsString(info);
            resp.getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
        日期转换
     */
    private void dateConvert() {
        ConvertUtils.register(new Converter() {
            public Object convert(Class type, Object value) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return simpleDateFormat.parse(value.toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }, Date.class);
    }

    /*
        添加数据功能
     */
    private void addStu(HttpServletRequest req, HttpServletResponse resp) {
        // 获取请求参数
        Map<String, String[]> map = req.getParameterMap();
        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");

        // 封装Student对象
        Student stu = new Student();

        // 注册日期转换器方法
        dateConvert();

        try {
            BeanUtils.populate(stu, map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 调用业务层的添加方法
        service.addStu(stu);

        // 重定向到分页查询功能
        try {
            resp.sendRedirect(req.getContextPath() + "/studentServlet?method=selectByPage&currentPage="
                    + currentPage + "&pageSize=" + pageSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
        修改数据功能
     */
    private void updateStu(HttpServletRequest req, HttpServletResponse resp) {
        // 获取请求参数
        Map<String, String[]> map = req.getParameterMap();
        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");

        // 封装Student对象
        Student stu = new Student();

        // 注册日期转换器方法
        dateConvert();

        try {
            BeanUtils.populate(stu, map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 调用业务层的修改方法
        service.updateStu(stu);

        // 重定向到分页查询功能
        try {
            resp.sendRedirect(req.getContextPath() + "/studentServlet?method=selectByPage&currentPage="
                    + currentPage + "&pageSize=" + pageSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
        删除数据功能
     */
    private void deleteStu(HttpServletRequest req, HttpServletResponse resp) {
        // 获取请求参数
        String number = req.getParameter("number");
        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");

        // 调用业务层的删除方法
        service.deleteStu(number);

        // 重定向到分页查询功能
        try {
            resp.sendRedirect(req.getContextPath() + "/studentServlet?method=selectByPage&currentPage="
                    + currentPage + "&pageSize=" + pageSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
