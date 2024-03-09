package com.yumo.example.provider;

import com.yumo.example.common.model.User;
import com.yumo.example.common.service.UserService;
import com.yumo.yurpc.registry.LocalRegistry;
import com.yumo.yurpc.server.VertxHttpServer;

/**
 * @description:
 * @author: <a href="https://github.com/coderyumo">程序员雨墨</a>
 * @create: 2024-03-09 14:47
 **/
public class EasyProviderExample {

    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.register(UserService.class.getName(),UserServiceImpl.class);

        // 启动 web 服务
        VertxHttpServer vertxHttpServer = new VertxHttpServer();
        vertxHttpServer.doStart(8080);

    }
}
