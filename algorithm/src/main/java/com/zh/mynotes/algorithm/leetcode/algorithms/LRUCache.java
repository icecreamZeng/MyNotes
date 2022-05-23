package com.zh.mynotes.algorithm.leetcode.algorithms;

import java.util.*;

/**
 * @Author zeng hao
 * @Description 最近最少使用(使用时间)
 * @Date Create in 2022/05/10 22:20
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

    Map<Integer, LinkNode> map;

    LinkNode head;
    LinkNode tail;
    int size;
    int capacity;


    LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        this.size = 0;
        head = new LinkNode();
        tail = new LinkNode();
        head.next = tail;
        tail.prev = head;
    }

    int get(int key) {
        LinkNode node = map.get(key);
        if (node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    void put(int key, int value) {
        LinkNode node = map.get(key);
        if (node == null){
            LinkNode newNode = new LinkNode(key, value);
            addToHead(newNode);
            map.put(key, newNode);
            size ++;
            if (size > capacity){
                LinkNode tail = removeTail();
                map.remove(tail.key);
                size --;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }

    private LinkNode removeTail() {
        LinkNode node = tail.prev;
        removeNode(node);
        return node;
    }

    private void moveToHead(LinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(LinkNode newNode) {
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
    }

    private void removeNode(LinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    class LinkNode{
        int key;
        int value;
        LinkNode next;
        LinkNode prev;
        public LinkNode(int key, int value){
            this.key = key;
            this.value = value;
        }

        public LinkNode(){

        }
    }
}
