package com.xingej.patterns.structuralType.proxy.dynamicProxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

/**
 * 动态代理测试
 * 
 * 要明白一点：
 * 
 * 动态代理与静态代理的区别？
 * 
 * 1、动态代理 的 代理者 是动态生成的，而静态代理 的代理者 是自己/程序员自己编写的
 * 
 * 2、处理器InvocationHandler 是用来进行 流程控制的
 * 
 * @author erjun 2017年11月15日 下午2:37:35
 */
public class Client {

    @Test
    public void test() {
        Star star = new RealStar();

        StarHandler handler = new StarHandler(star);

        // 生成的代理类，会自动继承 Star.class 接口
        // 真实角色 与 代理角色都会继承 同一个接口Star.class ，这样，才能说明，代理者能代理真实角色
        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] { Star.class },
                handler);

        // 注意一点：
        // 只要是代理类调用的方法，都会执行到invoke里

        proxy.sing();

        // proxy.bookTicket();

    }

}
