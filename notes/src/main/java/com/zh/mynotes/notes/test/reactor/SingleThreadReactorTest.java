package com.zh.mynotes.notes.test.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author zeng hao
 * @Description
 * @Date Create in 2021/12/18 0:22
 */
public class SingleThreadReactorTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress("localhost", 9999);
        serverSocketChannel.bind(address);
        serverSocketChannel.configureBlocking(false);

        Selector selector = Selector.open();

        SelectionKey serverKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        Handler handler = new AcceptHandler();
        handler.init(selector, serverSocketChannel);
        serverKey.attach(handler);

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

                Handler keyHandler = (Handler) key.attachment();
                keyHandler.run();

                iterator.remove();
            }
            Thread.sleep(5000);
        }
    }





}
