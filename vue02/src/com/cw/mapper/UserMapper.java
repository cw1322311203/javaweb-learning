package com.cw.mapper;

import com.cw.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 陈小哥cw
 * @date 2021/1/12 14:43
 */
public interface UserMapper {
    /*
        登录方法
     */
    @Select("select * from user where username=#{username} and password=#{password}")
    public abstract List<User> login(User user);
}
