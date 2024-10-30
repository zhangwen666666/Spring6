package com.zw.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class User implements BeanNameAware, BeanClassLoaderAware,
        BeanFactoryAware, InitializingBean, DisposableBean {
    private String name;

    public void setName(String name) {
        this.name = name;
        System.out.println("第二步：给对象的属性赋值");
    }

    public User(){
        System.out.println("第一步：无参数构造方法执行");
    }

    public void initBean(){
        System.out.println("第四步：初始化");
    }

    public void destroyBean(){
        System.out.println("第七步：销毁bean");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("类加载器：" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("工厂：" + beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("名字：" + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet方法执行");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean的destroy方法执行");
    }
}
