package com.yumo.example.consumer;

import com.yumo.example.common.model.User;
import com.yumo.example.common.service.UserService;
import com.yumo.yurpc.proxy.ServiceProxyFactory;

/**
 * @description:
 * @author: <a href="https://github.com/coderyumo">程序员雨墨</a>
 * @create: 2024-03-09 14:49
 **/
public class EasyConsumerExample {


    public static void main(String[] args) {
        // todo 需要获取UserService的实现类对象
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("zhangsan");
        User newUser = userService.getUser(user);
        if (newUser != null){
            System.out.println(newUser.getName());
        }else {
            System.out.println("user == null");
        }
    }
}
