package com.tlp.netty.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author：tlp
 * @crateDate：2019/10/9 20:24
 */
public class NioDemo {
    public static void main(String[] args)throws IOException {
        String path = "C:\\Users\\tlp\\Desktop\\测试.txt";
        FileInputStream is = new FileInputStream(path);
        FileChannel channel = is.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(1024);

        channel.read(buf);
        buf.flip();
        while (buf.hasRemaining()){
            byte b = buf.get();
            System.out.println((char) b);
        }
        channel.close();
    }
}
