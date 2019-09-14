package com.tlp.netty.nio;

import java.nio.IntBuffer;

/**
 * @author：tlp
 * @crateDate：2019/9/14 12:04
 */
public class BufferDemo {
    public static void main(String[] args) {
        IntBuffer buf = IntBuffer.allocate(10);
        buf.put(1);
        buf.put(2);
        buf.put(3);

        System.out.println(buf);
        buf.flip();
        System.out.println(buf);
        for (int i = 0; i < buf.limit(); i++) {
            System.out.println(buf.get());
        }
    }
}
