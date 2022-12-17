package com.zh.mynotes.notes.algorithm.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author zeng hao
 * @Description 最近最久未使用（使用频率）
 * @Date Create in 2022/05/10 22:20
 */
public class LFUCache {
    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3, 3);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        lfuCache.put(4, 4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
    }

    PriorityQueue<Node> queue;

     Map<Integer, Node> map;
    int capacity;
    int size;
    int time;
    LFUCache(int capacity) {
        queue = new PriorityQueue<>(Node::compareTo);
        map = new HashMap<>(capacity);
        this.size = 0;
        this.capacity = capacity;
    }

    int get(int key) {
        if (capacity == 0){
            return -1;
        }
        Node node  = map.get(key);
        if (node == null){
            return -1;
        }
        queue.remove(node);
        node.count ++;
        node.time = ++this.time;
        queue.add(node);
        return node.value;
    }

    void put(int key, int value) {
        if (capacity == 0){
            return;
        }
        Node node = map.get(key);
        if (node == null){
            size++;
            if (size > capacity){
                map.remove(queue.poll().key);
                size--;
            }
            node = new Node(key, value);
            node.time = ++this.time;
            queue.add(node);
            map.put(key, node);
        }else {
            queue.remove(node);
            node.value = value;
            node.time = ++this.time;
            node.count++;
            queue.add(node);
        }
    }

    class Node implements Comparable<Node>{
        int key;
        int value;
        int count;

        int time;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            count = 1;
            time = 0;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this){
                return true;
            }
            if (obj instanceof Node){
                return this.key== ((Node) obj).key;
            }
            return false;
        }

        @Override
        public int compareTo(Node o) {
            return this.count == o.count ? this.time - o.time : this.count - o.count;
        }
    }
}
