package com.xingej.patterns.structuralType.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 流程的控制 都是 通过invocationHandler 来处理的
 * 
 * @author erjun 2017年11月15日 下午2:46:48
 */
public class StarHandler implements InvocationHandler {
    // 被代理者(真实角色)
    private Star realStar;

    public StarHandler(Star star) {
        this.realStar = star;
    }

    // 可以通过invoke方法，实现对真实角色的代理方法
    // AOP横切面思想
    // 这里 处理 真正的角色
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object object = null;

        System.out.println("真正的执行者");
        System.out.println("面谈，签合同，订机票");

        // 如果调用的是sing方法的话，就调用真正的人
        if (method.getName().equals("sing")) {
            // 如果需要返回值的话，就添加Object的
            // realStar 被代理者，如歌星
            object = method.invoke(realStar, args);
        }

        System.out.println("真正的方法执行后");

        System.out.println("收尾款");
        return object;
    }

}
