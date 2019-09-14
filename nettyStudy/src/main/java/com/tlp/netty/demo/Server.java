package com.tlp.netty.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

import java.util.concurrent.CountDownLatch;

/**
 * @author：tlp
 * @crateDate：2019/9/14 13:58
 */
public class Server {
    static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {
        NioEventLoopGroup bossgroup = new NioEventLoopGroup();
        NioEventLoopGroup workgroup = new NioEventLoopGroup();

        ServerBootstrap b = new ServerBootstrap();
        b.group(bossgroup, workgroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel sc) throws Exception {
                        //解决粘包
                        ByteBuf byteBuf = Unpooled.copiedBuffer("$_".getBytes());
                        sc.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, byteBuf));
                       //设置字符串形式的解码
                        sc.pipeline().addLast(new StringDecoder());
                        sc.pipeline().addLast(new ServerHandler());
                    }
                });
//                .option(ChannelOption.SO_BACKLOG, 128)
//                .option(ChannelOption.SO_KEEPALIVE, true);

        //绑定指定端口进行监听
        ChannelFuture f = b.bind(8888).sync();

        //  latch.await();
        f.channel().closeFuture().sync();
        bossgroup.shutdownGracefully();
        workgroup.shutdownGracefully();

    }
}
