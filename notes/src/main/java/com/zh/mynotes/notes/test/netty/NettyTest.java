package com.zh.mynotes.notes.test.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author zeng hao
 * @Description
 * @Date Create in 2021/12/24 6:26
 */
public class NettyTest {
    public static void main(String[] args) throws InterruptedException {
        //服务端启动器
        ServerBootstrap bs = new ServerBootstrap();
        bs.localAddress(10080);
        //反应器组 默认 CPU数量*2
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup(1);
        //handler处理线程组
        EventLoopGroup workLoopGroup = new NioEventLoopGroup();
        //bs.group(eventLoopGroup);
        bs.group(eventLoopGroup, workLoopGroup);
        //只接收父通道类型
        bs.channel(NioServerSocketChannel.class);

        //设置子通道初始化工作
        bs.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                //将handler添加到pipeline
                ch.pipeline().addLast(new ChannelHandler() {
                    @Override
                    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
                        //在添加到pipeline后执行
                    }

                    @Override
                    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
                        //最后从pipeline中删除后执行
                        //注意这个时候已经不能处理事件了。
                    }

                    @Override
                    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                        //执行时发生异常时的处理方案
                    }
                });
            }
        });
        //绑定端口
        //bs.bind();
        //同步阻塞绑定端口
        ChannelFuture channelFuture = bs.bind().sync();

    }
}
