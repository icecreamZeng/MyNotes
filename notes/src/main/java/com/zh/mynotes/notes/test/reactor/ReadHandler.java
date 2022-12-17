package com.zh.mynotes.notes.test.reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @Author zeng hao
 * @Description
 * @Date Create in 2021/12/18 0:36
 */
public class ReadHandler implements Handler{
    SelectionKey key ;
    SocketChannel socketChannel ;
    ByteBuffer buffer = ByteBuffer.allocate(1024);


    @Override
    public void init(Selector selector, Channel channel) throws IOException {
        socketChannel = (SocketChannel) channel;
        System.out.println("客户端连接成功");
        System.out.println("client address :" + socketChannel.getRemoteAddress());
        socketChannel.configureBlocking(false);
        key = socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
        key.attach(this);
    }

    @Override
    public void run() throws IOException {

        SocketChannel socketChannel = (SocketChannel) key.channel();
        System.out.println(socketChannel.getRemoteAddress());
        int count = 0;
        while ( (count = socketChannel.read(buffer)) > 0 ){
            System.out.println("client msg :" + new String(buffer.array()));
        }
        buffer.clear();
        if (count > 0){
            System.out.println("连接持续中");
        }
        if (count == 0){
            System.out.println("无数据");
            System.out.println(socketChannel.read(buffer));
        }
        if (count < 0){
            System.out.println("连接断开");
            socketChannel.close();
        }
    }
}
