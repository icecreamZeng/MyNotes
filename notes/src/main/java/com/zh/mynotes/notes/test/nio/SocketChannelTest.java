package com.zh.mynotes.notes.test.nio;

import java.io.IOException;
import java.nio.channels.SocketChannel;

/**
 * @Author zeng hao
 * @Description
 * @Date Create in 2021/12/17 10:54
 */
public class SocketChannelTest {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);


    }
}
