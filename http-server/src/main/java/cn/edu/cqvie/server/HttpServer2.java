package cn.edu.cqvie.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class HttpServer2 {

    @lombok.SneakyThrows
    public static void main(String[] args) {
        //启动服务器，监听8888端口
        int port = 8888;
        ServerSocket server = new ServerSocket(port);
        System.out.println("服务端启动监听： " + port + "端口。");

        //不停接受客户端请求
        while (!Thread.interrupted()) {
            Socket s = server.accept();
            ServerThread serverThread = new ServerThread(s);
            new Thread(serverThread).start();
        }

        server.close();
    }
}
