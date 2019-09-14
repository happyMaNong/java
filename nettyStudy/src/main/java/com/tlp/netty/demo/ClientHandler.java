package com.tlp.netty.demo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

/**
 * @author：tlp
 * @crateDate：2019/9/14 14:07
 */
public class ClientHandler extends ChannelHandlerAdapter {
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
//            ByteBuf buf = (ByteBuf) msg;
//            byte[] bytes = new byte[buf.readableBytes()];
//            buf.readBytes(bytes);
//            String s = new String(bytes, "utf-8");
            String s = (String) msg;
            System.out.println("服务器端发来的信息：" + s);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
