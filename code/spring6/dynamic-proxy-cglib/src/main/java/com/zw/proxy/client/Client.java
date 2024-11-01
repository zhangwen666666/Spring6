package com.zw.proxy.client;

import com.zw.proxy.service.UserService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Client {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object target, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                long begin = System.currentTimeMillis();
                Object retValue = methodProxy.invokeSuper(target, objects);
                long end = System.currentTimeMillis();
                System.out.println("耗时" + (end - begin) + "毫秒");
                return retValue;
            }
        });
        UserService userService = (UserService) enhancer.create();
        boolean success = userService.login("admin", "123");
        System.out.println(success ? "登录成功" : "登录失败");
        userService.logout();
        System.out.println(userService);
    }
}
