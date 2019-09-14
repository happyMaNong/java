package com.tlp.netty.socket;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author：tlp
 * @crateDate：2019/9/14 10:56
 */
public class ServerSocketDemo {
    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("127.0.0.1", 8888));
            while (true) {
                Socket socket = serverSocket.accept();

                byte[] bytes = new byte[1024];
                int len = socket.getInputStream().read(bytes);
                System.out.println(new String(bytes, 0, len));

                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("恭喜你已经连接上服务器".getBytes());
                outputStream.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
