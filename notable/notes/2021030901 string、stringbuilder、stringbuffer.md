---
attachments: [Clipboard_2021-03-10-02-58-38.png, Clipboard_2021-03-10-03-38-09.png, Clipboard_2021-03-10-11-04-11.png, Clipboard_2021-03-10-11-08-12.png, Clipboard_2021-03-10-11-08-40.png, Clipboard_2021-03-10-11-09-20.png, Clipboard_2021-03-10-11-11-30.png]
tags: [1（目录）/Java技能树/Java/Java基础, 2（完成状态）/DONE, 3（完成时间）/2021/03/10, 线程安全, String]
title: 2021030901 string、stringbuilder、stringbuffer
created: '2021-03-09T06:49:08.405Z'
modified: '2021-03-10T18:42:08.480Z'
---

# 2021030901 string、stringbuilder、stringbuffer 
https://blog.csdn.net/u011702479/article/details/82262823

String: 不可变字符序列
StringBuffer: 可变字符序列，效率低下，线程安全
StringBuilder（JDK1.5）: 可变字符序列，高效，线程不安全

# 为什么要有 StringBuilder和StringBuffer？

​     String 字符串属于对象，但是String是不可变对象，导致每次对string操作，如果新的字符串在常量池里面不存在，则会生成新的对象，如果操作过于频繁，效率低下，并且会浪费大量的内存。
![](@attachment/Clipboard_2021-03-10-03-38-09.png)

​     针对这种情况，google引入了stringBuilder和stringBuffer来处理可变字符串的处理。
![](@attachment/Clipboard_2021-03-10-02-58-38.png)
![](@attachment/Clipboard_2021-03-10-11-09-20.png)
![](@attachment/Clipboard_2021-03-10-11-08-12.png)
![](@attachment/Clipboard_2021-03-10-11-08-40.png)
​     相对于 String ，StringBuilder 和 StringBuffer对象操作不会产生新的字符串。其中，StringBuilder 高效但是线程不安全，适用于大多数不要求线程安全的场景，如果对线程安全有要求才会考虑使用StringBuffer。
​     每个StringBuffer对象都有一定的缓冲区容量，当字符串大小没有超过容量时，不会分配新的容量，当字符串大小超过容量时，会自动增加容量,默认值是 16 字节
![](@attachment/Clipboard_2021-03-10-11-11-30.png)
StringBuilder提供了与StringBuilder兼容的API。

# StringBuffer是怎么保证线程安全的？

![](@attachment/Clipboard_2021-03-10-11-04-11.png)

# String 什么情况下会保存到常量池？
https://segmentfault.com/a/1190000009888357

新生成的字符串如果不在常量池中，字符串会被实例化并存储到常量池中，会在栈中生成一个引用指向这个常量







