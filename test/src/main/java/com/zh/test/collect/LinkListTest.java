package com.zh.test.collect;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author: Zeng Hao
 * @Description:
 * @Date: Created in 2021/6/25 15:16
 */
public class LinkListTest {
    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("a");
        a.add("c");
        a.add("e");
        List<String> b = new LinkedList<>();
        b.add("b");
        b.add("d");
        b.add("f");
        b.add("g");
        ListIterator<String> aIterator = a.listIterator(0);
        ListIterator<String> bIterator = b.listIterator(0);
        while (bIterator.hasNext()){
            if (aIterator.hasNext()){
                aIterator.next();
            }
            aIterator.add(bIterator.next());
        }
        System.out.println(a);
        //理想很美好，迭代器的指针已经放到链表末尾了
        while (bIterator.hasNext()){
            bIterator.next();
            if (bIterator.hasNext()){
                bIterator.next();
                bIterator.remove();
            }
        }
        System.out.println(b);
        a.removeAll(b);
        System.out.println(a);
    }
}
