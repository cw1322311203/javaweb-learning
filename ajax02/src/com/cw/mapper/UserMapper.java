package com.cw.mapper;

import com.cw.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    /*
        模糊查询
     */
    @Select("SELECT * FROM user WHERE name LIKE concat('%',#{username},'%')")
    public abstract List<User> selectLike(String username);
}
