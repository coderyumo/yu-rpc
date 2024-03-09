package com.yumo.example.provider;

import com.yumo.example.common.model.User;
import com.yumo.example.common.service.UserService;

/**
 * @description:
 * @author: <a href="https://github.com/coderyumo">程序员雨墨</a>
 * @create: 2024-03-09 14:45
 **/
public class UserServiceImpl implements UserService {


    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}
