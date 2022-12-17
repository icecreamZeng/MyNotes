package com.zh.mynotes.notes.test.collect;

/**
 * @Author: Zeng Hao
 * @Description:
 * @Date: Created in 2021/6/25 17:37
 */
public class Item implements Comparable{
    private String key;
    private Integer value;

    public String getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }

    public Item(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        return this.value.compareTo(((Item)o).getValue());
    }

    @Override
    public String toString() {
        return "Item{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}
