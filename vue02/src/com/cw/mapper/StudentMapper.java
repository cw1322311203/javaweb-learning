package com.cw.mapper;

import com.cw.bean.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author 陈小哥cw
 * @date 2021/1/12 15:36
 * <p>
 * 学生持久层接口
 */
public interface StudentMapper {
    /*
        查询全部方法
     */
    @Select("select * from student")
    public abstract List<Student> selectAll();

    /*
        添加数据方法
     */
    @Insert("insert into student values (#{number},#{name},#{birthday},#{address})")
    public abstract void addStu(Student stu);

    /*
        修改数据方法
     */
    @Update("update student set number=#{number},name=#{name},birthday=#{birthday},address=#{address} where number=#{number}")
    public abstract void updateStu(Student stu);

    /*
        删除数据方法
     */
    @Delete("delete from student where number=#{number}")
    public abstract void deleteStu(String number);
}
