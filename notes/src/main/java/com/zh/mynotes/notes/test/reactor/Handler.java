package com.zh.mynotes.notes.test.reactor;

import java.io.IOException;
import java.nio.channels.Channel;
import java.nio.channels.Selector;

public interface Handler {
    void init(Selector selector, Channel channel) throws IOException;
    void run() throws IOException;
}
