package com.yumo.yurpc.server;

/**
 * @description:
 * @author: <a href="https://github.com/coderyumo">程序员雨墨</a>
 * @create: 2024-03-09 14:54
 **/
public interface HttpServer {

    /**
     * 启动服务器
     */
    void doStart(int port);
}
