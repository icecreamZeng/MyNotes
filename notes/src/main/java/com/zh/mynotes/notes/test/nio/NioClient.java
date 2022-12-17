package com.zh.mynotes.notes.test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Author zeng hao
 * @Description
 * @Date Create in 2021/12/17 11:15
 */
public class NioClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        SocketChannel socketChannel = SocketChannel.open();
        InetSocketAddress address = new InetSocketAddress("localhost", 9999);
        socketChannel.configureBlocking(false);
        boolean connect = socketChannel.connect(address);
        if (!connect){
            while (!socketChannel.finishConnect()){
                System.out.println("服务器连接中....");
                Thread.sleep(1000);
            }
        }
        String msg = "msg to server";
        ByteBuffer wrap = ByteBuffer.wrap(msg.getBytes());
        socketChannel.write(wrap);
        Thread.sleep(10000);
        socketChannel.shutdownInput();
        socketChannel.close();
    }
}
