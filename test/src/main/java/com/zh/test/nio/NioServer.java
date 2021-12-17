package com.zh.test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author zeng hao
 * @Description
 * @Date Create in 2021/12/17 11:14
 */
public class NioServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress("localhost", 9999);
        serverSocketChannel.bind(address);
        serverSocketChannel.configureBlocking(false);

        Selector selector = Selector.open();

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            if (selector.select(1000) == 0){
                System.out.println("服务器等待连接...");
                continue;
            }

            Set<SelectionKey> keys = selector.selectedKeys();
            System.out.println("key size: " + keys.size());

            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                System.out.println("key type:" + key.readyOps());
                if (key.isAcceptable()){
                    SocketChannel accept = serverSocketChannel.accept();
                    System.out.println("客户端连接成功");
                    System.out.println("client address :" + accept.getRemoteAddress());
                    accept.configureBlocking(false);

                    accept.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));

                }
                if (key.isReadable()){
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
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
                iterator.remove();
            }
            Thread.sleep(5000);
        }
    }
}
