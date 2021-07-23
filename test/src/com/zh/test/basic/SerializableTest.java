package com.zh.test.basic;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Author: Zeng Hao
 * @Description:
 * @Date: Created in 2021/6/25 23:33
 */
public class SerializableTest {

    private static ObjectMapper mapper = new ObjectMapper();
    static {
        // 对于空的对象转json的时候不抛出错误
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        // 允许属性名称没有引号
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        // 允许单引号
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        // 设置输入时忽略在json字符串中存在但在java对象实际没有的属性
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // 设置输出时包含属性的风格
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    static String jacksonToStr(Object v){
        if (v == null){
            return null;
        }
        String str = null;
        try {
            str = mapper.writeValueAsString(v);
        }catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return str;
    }

    static void javaToStr(Object v){
        if (v == null){
            return ;
        }
        try (
                ObjectOutputStream objOStream = new ObjectOutputStream(new FileOutputStream("output.txt"));
                ){
            objOStream.writeObject(v);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String fastJsonToStr(Object o){
        if (o == null){
            return null;
        }
        return JSON.toJSONString(o);
    }

    public static void main(String[] args) {
        Person a = new Person("a", 1, "jackson序列化");
        //jackson 无序 实现 Serializable 接口 ,transient 无效;
        System.out.println(jacksonToStr(a));
        //transient 有效
        Person b = new Person("b", 2, "fastjson序列化");
        System.out.println(fastJsonToStr(b));
        Person c = new Person("c", 3, "java序列化");
        javaToStr(c);//NotSerializableException
    }
}
