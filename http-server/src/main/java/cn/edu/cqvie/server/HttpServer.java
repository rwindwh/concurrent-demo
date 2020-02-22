package cn.edu.cqvie.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class HttpServer {

    @lombok.SneakyThrows
    public static void main(String[] args) {
        //启动服务器，监听8888端口
        int port = 8888;
        ServerSocket server = new ServerSocket(port);
        System.out.println("服务端启动监听： " + port + "端口。");

        //不停接受客户端请求
        while (!Thread.interrupted()) {
            //不停接受客户端请求
            Socket client = server.accept();

            //获取输入输出流
            InputStream ins = client.getInputStream();
            OutputStream out = client.getOutputStream();

            //读取请求内容
//            int len = 0;
//            byte[] b = new byte[1024];
//            len = ins.read(b);
//            System.out.println(new String(b, 0, len));
//            while ((len = ins.read(b)) != 0) {
//                System.out.println(new String(b, 0, len));
//            }

            //读取请求内容
            BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
            String text = null;
            while ((text = reader.readLine()) != null) {
                System.out.println(text);
                break;
            }

            //给用户响应
            InputStream in = HttpServer.class.getClassLoader().getResourceAsStream("static/index.html");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            PrintWriter pw = new PrintWriter(out);
            pw.println("HTTP/1.1 200 OK");
            pw.println("Content-Type: text/html;charset=utf-8");
            pw.println("Content-Length:" + in.available());
            pw.println("Date:" + new Date());
            pw.println("Server: Zomcat");
            pw.println("");
            pw.flush();

            String c = null;
            while ((c = bufferedReader.readLine()) != null) {
                pw.println(c);
            }
            pw.flush();
            pw.close();

        }

        server.close();
    }
}
