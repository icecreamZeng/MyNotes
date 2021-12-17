package com.zh.test.reactor;

import java.io.IOException;
import java.nio.channels.Channel;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/*K*
 * @Author zeng hao
 * @Description
 * @Date Create in 2021/12/18 0:35
 */
public class AcceptHandler implements Handler {
    ServerSocketChannel serverSocketChannel;
    Selector selector;
    @Override
    public void init(Selector selector, Channel channel) {
        serverSocketChannel = (ServerSocketChannel) channel;
        this.selector = selector;
    }

    @Override
    public void run() throws IOException {
        new ReadHandler().init(selector, serverSocketChannel.accept());
    }
}
