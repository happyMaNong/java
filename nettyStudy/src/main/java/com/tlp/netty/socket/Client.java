package com.tlp.netty.socket;

import java.io.*;

import java.net.Socket;

/**
 * @author：tlp
 * @crateDate：2019/9/14 11:05
 */
public class Client {
    public static void main(String[] args){
        Socket socket = null;
        try {
           socket = new Socket("127.0.0.1",8888);

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("请求连接服务器".getBytes());
            outputStream.flush();

            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = socket.getInputStream().read(bytes);
            System.out.println(new String(bytes, 0, len));

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
