# Java基础
  - [前言](#前言)
  - [String、StringBuilder、StringBuffer](#stringstringbuilderstringbuffer)
  - [java反射](#java反射)
  - [java异常](#java异常)
  - [java IO](#java-io)
  - [hashCode](#hashcode)
  - [单例模式](#单例模式)
  - [观察者模式](#观察者模式)
  - [适配器模式](#适配器模式)

## 前言
​     		本章介绍java相关面试中被问及的java基础知识，包括相关的工具类，高级JDK新增的功能。

## String、StringBuilder、StringBuffer

### 特性介绍 
- 1、字符串就是一连串的**字符串序列**
- 2、String 属于*不可变类*，一旦一个String 对象被创建后，包含在这个对象中的字符序列是不可改变的，**直到对象被销毁**
- 3、StringBuffer 对象代表的是一个**字符序列可变的字符串**，通过提供的append()、insert()、reverse()、setCharAt()、setLength()方法改变字符串的字符序列
- 4、StringBuilder 是 JDK1.5新增的类,与StringBuffer基本相似，构造器与方法基本相同。
- 5、**StringBuffer线程安全**，性能相较StringBuilder 略低，通常情况下,**优先使用StringBuilder**

##  java反射
[参考文章:Java基础之—反射（非常重要）](https://blog.csdn.net/sinat_38259539/article/details/71799078)

​	使用的前提条件：必须先得到代表的字节码的Class，Class类用于表示.class文件（字节码）

### 反射的概述
#### [百度百科:](https://baike.baidu.com/item/JAVA%E5%8F%8D%E5%B0%84%E6%9C%BA%E5%88%B6/6015990)
>JAVA反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意方法和属性；这种动态获取信息以及动态调用对象方法的功能称为java语言的反射机制。



**个人理解：**

​	对于在编译期未知的class,可以运用java的反射机制来自主构造这个类的对象，,绕过类型和修饰符的限制，实现属性赋值，并调用它的方法。

​	这一点正是有利于各种通用框架的搭建，比如spring框架会根据配置的类的信息自动注入到bean;还有在使用IDE时，在输入一个对象或者类名时，会自动提示该对象或类的属性和方法。

## java异常

### Java中的两种异常类型是什么？他们有什么区别？

![异常类的结构](https://coding.net/s/cf8bf2ff-96c3-498a-ae1e-70458f585cef) 

java异常分为**运行时异常(checked exception)** 和**非运行时异常(unchecked exception)** 

(1) 运行时异常(checked exception)



(2) 非运行时异常(unchecked exception) 


## java IO

## hashCode

## 单例模式

## 观察者模式

## 适配器模式