package com.zh.mynotes.notes.test.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author zeng hao
 * @Description
 * @Date Create in 2021/12/03 15:42
 */
public class NioTest {
    public static void main(String[] args) {
        String msg = "一顿操作猛如虎，一看战绩0杠5";
        ByteBuffer allocate = ByteBuffer.allocate(50);
        CharBuffer.allocate(50);
        byte[] bytes = msg.getBytes();
        allocate.put(bytes); // 写入数据到Buffer中
        allocate.flip(); // 切换成读的模式
        byte[] tempByte = new byte[bytes.length]; // 用于存放数据的数组
        int i = 0;
        while (allocate.hasRemaining()) {
            byte b = allocate.get();
            tempByte[i] = b;
            i++;
        }
        System.out.println(new String(tempByte));

        //channel
        String rootPath = ClassLoader.getSystemResource("").getPath();
        File file = new File(rootPath + "/source.txt");
        try(
                FileInputStream fileInputStream = new FileInputStream(file);
                FileChannel inputChannel = fileInputStream.getChannel();
                FileInputStream fileInputDirectStream = new FileInputStream(file);
                FileChannel inputDirectChannel = fileInputDirectStream.getChannel();
                FileOutputStream fileOutputStream = new FileOutputStream(rootPath + "/dest.txt");
                FileChannel outChannel = fileOutputStream.getChannel();
                FileOutputStream fileDirectStream = new FileOutputStream(rootPath + "/directDest.txt");
                FileChannel directChannel = fileDirectStream.getChannel();
                ) {
            ByteBuffer heapBuffer = ByteBuffer.allocate(10);
            ByteBuffer directBuffer = ByteBuffer.allocateDirect(10);

            while (inputChannel.read(heapBuffer) != -1){
                heapBuffer.flip();
                outChannel.write(heapBuffer);
                heapBuffer.clear();
            }
            while (inputDirectChannel.read(directBuffer) != -1){
                directBuffer.flip();
                directChannel.write(directBuffer);
                directBuffer.clear();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Short sh = 1;
        Byte b1 = sh.byteValue();

        Float f = 1.0f;
        Byte b = f.byteValue();

        Double d = 1.23;
        Byte b3 = d.byteValue();

        Character ch = '1';
        Byte b4 = (byte) ch.charValue();

    }
}
