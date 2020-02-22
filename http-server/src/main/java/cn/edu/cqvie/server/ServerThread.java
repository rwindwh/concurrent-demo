package cn.edu.cqvie.server;

import lombok.SneakyThrows;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ServerThread implements Runnable {

    private Socket client;
    private static Map<String, String> contentMap = new HashMap<>();
    private final String ROOT_PATH = "static";

    static {
        contentMap.put("html", "text/html;charset=utf-8");
        contentMap.put("jpeg", "image/jpeg");
    }

    public ServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            go();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void go() throws Exception {

        //获取输入输出流
        InputStream ins = client.getInputStream();
        OutputStream out = client.getOutputStream();

        //读取请求内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
        String text = null;
        String firstLine = reader.readLine();
        System.out.println(firstLine);
        String[] s = firstLine.split("\\s");

        //默认首页
        String url = "index";
        String suffix = "html";
        if (s.length >= 2) {
            url = s[1];
            if ("/".equals(url)) {
                url = "/index.html";
            } else {
                suffix = url.split("\\.")[1];
            }
        }
        while (isNotEmpty((text = reader.readLine()))) {
            System.out.println(text);
        }

        //给用户响应
        InputStream in = HttpServer2.class.getClassLoader().getResourceAsStream(ROOT_PATH + url);
        PrintWriter pw = new PrintWriter(out);
        if (in == null) {
            pw.println("HTTP/1.1 404 OK");
        } else {
            pw.println("HTTP/1.1 200 OK");
            //内容类型
            pw.println("Content-Type: " + contentMap.get(suffix));
            pw.println("Content-Length:" + in.available());
            pw.println("Date:" + new Date());
            pw.println("Server: hello");
            pw.println("");
            pw.flush();

            int len = 0;
            byte[] buff = new byte[1024];
            while ((len = in.read(buff)) != -1) {
                out.write(buff, 0, len);
            }
        }
        pw.flush();
        pw.close();
        in.close();
        reader.close();
        client.close();
    }

    public boolean isNotEmpty(String str) {
        return str != null && !str.trim().equals("");
    }
}
