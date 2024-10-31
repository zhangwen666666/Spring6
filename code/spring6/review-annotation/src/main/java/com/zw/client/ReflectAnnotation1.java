package com.zw.client;

import com.zw.annotation.Component;

public class ReflectAnnotation1 {
    public static void main(String[] args) throws Exception{
        Class<?> clazz = Class.forName("com.zw.bean.User");
        // 判断类上是否有注解
        boolean isAnnotation = clazz.isAnnotationPresent(Component.class);
        if(isAnnotation){
            // 有注解,获取注解
            Component annotation = clazz.getAnnotation(Component.class);
            String value = annotation.value();
            System.out.println(value);
        }
    }
}
