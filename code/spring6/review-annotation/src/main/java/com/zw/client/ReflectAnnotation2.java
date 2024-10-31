package com.zw.client;

import com.zw.annotation.Component;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ReflectAnnotation2 {
    public static void main(String[] args) {
        Map<String, Object> beans = ReflectAnnotation2.getBeans("com.zw.bean");
        beans.forEach((k, v) -> {
            System.out.println(k + "=" + v);
        });
    }

    public static Map<String, Object> getBeans(String packageName) {
        Map<String, Object> beans = new HashMap<>();
        // 通过包名获取文件夹名
        String packagePath = packageName.replaceAll("\\.","/");
        // System.out.println(packagePath);
        URL url = ClassLoader.getSystemClassLoader().getResource(packagePath);
        // System.out.println(url.getPath());
        File packageDir = new File(url.getPath());
        if(packageDir.isDirectory()){
            // 是一个文件夹，获取其所有子文件和子文件夹
            File[] files = packageDir.listFiles();
            for (File file : files) {
                // 如果是.java结尾的文件
                if (file.getName().endsWith(".class") && file.isFile()){
                    // System.out.println(file.getName().split("\\.")[0]);
                    // 拼接类名
                    String className = packageName + "." + file.getName().split("\\.")[0];
                    // System.out.println(className);
                    try {
                        Class<?> clazz = Class.forName(className);
                        if(clazz.isAnnotationPresent(Component.class)){
                            // 有@Component注解
                            Component annotation = clazz.getAnnotation(Component.class);
                            String beanId = annotation.value();
                            Constructor<?> constructor = clazz.getDeclaredConstructor();
                            Object bean = constructor.newInstance();
                            beans.put(beanId, bean);
                        }
                    } catch (ClassNotFoundException e) {
                        System.out.println(className + "类不存在");
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    } catch (InstantiationException e) {
                        throw new RuntimeException(e);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return beans;
    }
}
