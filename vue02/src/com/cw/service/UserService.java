package com.cw.service;

import com.cw.bean.User;

import java.util.List;

/**
 * @author 陈小哥cw
 * @date 2021/1/12 14:44
 */
public interface UserService {
    /*
        登录方法
     */
    public abstract List<User> login(User user);
}
