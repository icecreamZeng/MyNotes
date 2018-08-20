# Java基础
[TOC]

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
 **[百度百科](https://baike.baidu.com/item/JAVA%E5%8F%8D%E5%B0%84%E6%9C%BA%E5%88%B6/6015990)**
>JAVA反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意方法和属性；这种动态获取信息以及动态调用对象方法的功能称为java语言的反射机制。



### 个人理解

​	对于在编译期未知的class,可以运用java的反射机制来自主构造这个类的对象，,绕过类型和修饰符的限制，实现属性赋值，并调用它的方法。
​	这一点正是有利于各种通用框架的搭建，比如spring框架会根据配置的类的信息自动注入到bean;还有在使用IDE时，在输入一个对象或者类名时，会自动提示该对象或类的属性和方法。

## java异常



>程序运行时，发生的不被期望的事件，它阻止了程序按照程序员的预期正常执行，这就是异常。 
>Java提供了优秀的解决办法：异常处理机制。 
>异常处理机制能让程序在异常发生时，按照代码的预先设定的异常处理逻辑，针对性地处理异常，让程序尽最大可能恢复正常并继续执行，且保持代码的清晰。 



![异常类的结构](https://dn-coding-net-production-file.qbox.me/6f808ba0-a3ba-11e8-a656-3754f01d039a.png?e=1534691967&token=goE9CtaiT5YaIP6ZQ1nAafd_C1Z_H2gVP8AwuC-5:mYVcSYXg3dzg8m0fB3OCnQGJDU4=) 

### 1.Error与Exception的区别

Exception和Error都是Throwable的子类。

Exception用于用户程序可以捕获的异常情况。

Error定义了不期望被用户程序捕获的异常。 Error类以及它的子类代表JVM本身的错误，不能被程序员通过代码处理。

### 2.Java中的两种异常类型是什么？他们有什么区别？

java异常分为**受检查异常/非运行时异常(checked exception)** 和**不受检查异常/运行时异常(unchecked exception)** 

(1) 受检查异常/非运行时异常(checked exception)：继承自java.lang. Exception类 

是 RuntimeException以外的异常,类型上都属于Exception类及其子类 。
这种异常强制用户去处理，否则编译不会通过。



常见：

Java.lang.ClassNotFoundException

Java.lang.NoSuchMetodException

java.io.IOException



(2) 不受检查异常/运行时异常(unchecked exception) ：继承自java.lang.RuntimeException 类 。



常见有以下几种：

ClassCastException(类型转换异常);

IndexOutOfBoundsException(数组越界异常);

NullPointerException(空指针异常);

ArrayStoreException(数据存储异常，操作数组时类型不一致 );



**区别：**

Checked异常必须被显式地捕获或者传递，而unchecked异常则可以不必捕获或抛出。 

### 3.throw，throws，try-catch的联系 

(1) throw:自己手动抛出异常。如果程序运行到此处绝对会出现异常。

示例如下：


```java
public void fun1(int m) throws Exception{
int age=m;
if (age<0) {
    throw new Exception();
}
}
```


```java
public void fun2() {
	try {
        fun1(-1);           
	} catch (Exception e) {
    System.out.println("年龄不能为负");
	}
}
```

上面的示例抛出的是非运行时异常，程序需要显式的去处理，若抛出的是运行时异常，程序不做处理，编译器也不会报错。

因为运行时异常产生频繁，处理麻烦，若显示申明或者捕获会对程序的可读性和运行效率影响很大。所以由系统检测并将它们交给缺省的异常处理程序。

(2) throws :用在方法噶声明之后，表示该方法可能会抛出的异常

(3) try-catch :用来处理异常，try中写尝试运行的代码，catch中写遇见异常的处理方式。

遇见代码抛出非运行时异常，要么即时使用try-catch处理，要么使用throws在所在方法处抛出，交由该方法调用者处理。

## java IO

## hashCode

## 单例模式

## 观察者模式

## 适配器模式
