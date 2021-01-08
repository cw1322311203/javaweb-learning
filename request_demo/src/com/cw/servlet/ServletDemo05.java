package com.cw.servlet;

import com.cw.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author 陈小哥cw
 * @date 2021/1/6 15:19
 * <p>
 * TODO 封装对象-反射方式
 * 使用反射+内省实现数据模型的封装
 * 内省：是sun公司推出的一套简化反射操作的规范。把javabean中的元素都封装成一个属性描述器。
 * 属性描述器中会有字段信息，get和set方法（取值或存值）
 */
@WebServlet("/servletDemo05")
public class ServletDemo05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取所有的数据
        Map<String, String[]> map = req.getParameterMap();

        // 2.封装学生对象
        Student stu = new Student();
        // 2.1遍历集合
        for (String name : map.keySet()) {
            String[] value = map.get(name);
            try {
                // 2.2获取Student对象的属性描述器
                // 拿到Student对象中的属性描述器。是谁的属性描述器：是由构造函数的第一个参数决定的。第二个参数是指定javabean的字节
                PropertyDescriptor pd = new PropertyDescriptor(name, stu.getClass());
                // 2.3获取对象的setXxx方法
                Method writeMethod = pd.getWriteMethod();
                // 2.4执行方法
                if (value.length > 1) {
                    writeMethod.invoke(stu, (Object) value);// 第一个参数是指的给哪个对象，第二个参数指的是赋什么值
                } else {
                    writeMethod.invoke(stu, value);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 3.输出学生对象
        System.out.println(stu);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
