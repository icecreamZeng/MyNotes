package com.zh.test.basic;

import java.io.Serializable;

/**
 * @Author: Zeng Hao
 * @Description:
 * @Date: Created in 2021/6/25 23:33
 */
public class Person implements Serializable {
    private String name;

    private int age;

    private transient String remark;

    public Person(String name, int age, String remark) {
        this.name = name;
        this.age = age;
        this.remark = remark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
