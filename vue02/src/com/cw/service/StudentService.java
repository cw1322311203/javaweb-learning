package com.cw.service;

import com.cw.bean.Student;
import com.github.pagehelper.Page;

/**
 * @author 陈小哥cw
 * @date 2021/1/12 15:35
 * <p>
 * 学生业务层接口
 */
public interface StudentService {
    /*
        分页查询方法
     */
    public abstract Page selectByPage(Integer currentPage, Integer pageSize);

    /*
        添加数据方法
     */
    public abstract void addStu(Student stu);

    /*
        修改数据方法
     */
    public abstract void updateStu(Student stu);

    /*
        删除数据方法
     */
    public abstract void deleteStu(String number);
}
