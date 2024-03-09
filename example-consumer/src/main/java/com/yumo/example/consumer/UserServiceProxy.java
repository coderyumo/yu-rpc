package com.yumo.example.consumer;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.yumo.example.common.model.User;
import com.yumo.example.common.service.UserService;
import com.yumo.yurpc.model.RpcRequest;
import com.yumo.yurpc.model.RpcResponse;
import com.yumo.yurpc.serializer.JdkSerializer;
import com.yumo.yurpc.serializer.Serializer;

import java.io.IOException;

/**
 * @description: 静态代理
 * @author: <a href="https://github.com/coderyumo">程序员雨墨</a>
 * @create: 2024-03-09 15:52
 **/
public class UserServiceProxy implements UserService {


    public User getUser(User user) {
        // 指定序列化器
        Serializer serializer = new JdkSerializer();

        // 发请求
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(UserService.class.getName())
                .methodName("getUser")
                .parameterTypes(new Class[]{User.class})
                .args(new Object[]{user})
                .build();
        try {

            byte[] bodyBytes = serializer.serialize(rpcRequest);
            byte[] result;
            try (HttpResponse httpResponse = HttpRequest.post("http://localhost:8080").body(bodyBytes).execute()) {
                result = httpResponse.bodyBytes();
            }
            RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
            return (User) rpcResponse.getData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
