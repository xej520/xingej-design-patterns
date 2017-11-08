package com.xingej.patterns.singleton.example2;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class SingleDemo01Test {

    @Test
    public void testSingleton() {
        LazyMethod instance1 = LazyMethod.getInstacne();
        LazyMethod instance2 = LazyMethod.getInstacne();

        System.out.println("---class--->\t" + instance1);
        System.out.println("---class--->\t" + instance2);

    }

    // 使用反射来破解，懒汉式单例模式哦
    // 说明，
    // 已经使用SingleDemo01.getInstacne() 创建了实例instance1，
    // instance2，这两个实例都是一个对象，只是引用不一样
    // 然后，又通过反射创建了一个实例，运行之后，你可以观察输出结果是不一样的
    @Test
    public void testSingletonByPojie() throws Exception {

        LazyMethod instance1 = LazyMethod.getInstacne();
        LazyMethod instance2 = LazyMethod.getInstacne();

        System.out.println("---class--->\t" + instance1);
        System.out.println("---class--->\t" + instance2);

        @SuppressWarnings("unchecked")
        Class<LazyMethod> clazz = (Class<LazyMethod>) Class
                .forName("com.xingej.patterns.singleton.example2.LazyMethod");

        Constructor<LazyMethod> constructor = clazz.getDeclaredConstructor(null);

        constructor.setAccessible(true);

        LazyMethod instance1a = constructor.newInstance(null);
        // SingleDemo01 instance2a = constructor.newInstance(null);

        System.out.println("---class--->\t" + instance1a);
        // System.out.println("---class--->\t" + instance2a);

    }

    // 反破解测试，
    @Test
    public void testSingletonByPojie2() throws Exception {

        LazyMethod2 instance1 = LazyMethod2.getInstacne();
        LazyMethod2 instance2 = LazyMethod2.getInstacne();

        System.out.println("---class--->\t" + instance1);
        System.out.println("---class--->\t" + instance2);

        @SuppressWarnings("unchecked")
        Class<LazyMethod2> clazz = (Class<LazyMethod2>) Class
                .forName("com.xingej.patterns.singleton.example2.SingleDemo02");

        Constructor<LazyMethod2> constructor = clazz.getDeclaredConstructor(null);

        constructor.setAccessible(true);

        LazyMethod2 instance1a = constructor.newInstance(null);

        LazyMethod2 instance2a = constructor.newInstance(null);

        System.out.println("---class--2->\t" + instance1a);

        System.out.println("---class--2->\t" + instance2a);

    }

}
