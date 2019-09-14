package com.tlp.netty.demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author：tlp
 * @crateDate：2019/9/14 14:14
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel sc) throws Exception {
                        //解决粘包
                        ByteBuf byteBuf = Unpooled.copiedBuffer("$_".getBytes());
                        sc.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, byteBuf));
                        //设置字符串形式的解码
                        sc.pipeline().addLast(new StringDecoder());
                        sc.pipeline().addLast(new ClientHandler());
                    }
                });

        ChannelFuture cf = bootstrap.connect("127.0.0.1", 8888).sync();
        cf.channel().writeAndFlush(Unpooled.wrappedBuffer("你好aaaa$_".getBytes()));
        cf.channel().writeAndFlush(Unpooled.wrappedBuffer("你好bbbb$_".getBytes()));
        cf.channel().writeAndFlush(Unpooled.wrappedBuffer("你好cccc$_".getBytes()));
        cf.channel().closeFuture().sync();
        group.shutdownGracefully();
    }
}
