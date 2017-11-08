package com.xingej.patterns.singleton.example2;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class SingleDemo01Test {

    @Test
    public void testSingleton() {
        SingleDemo01 instance1 = SingleDemo01.getInstacne();
        SingleDemo01 instance2 = SingleDemo01.getInstacne();

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

        SingleDemo01 instance1 = SingleDemo01.getInstacne();
        SingleDemo01 instance2 = SingleDemo01.getInstacne();

        System.out.println("---class--->\t" + instance1);
        System.out.println("---class--->\t" + instance2);

        @SuppressWarnings("unchecked")
        Class<SingleDemo01> clazz = (Class<SingleDemo01>) Class
                .forName("com.xingej.patterns.singleton.example2.SingleDemo01");

        Constructor<SingleDemo01> constructor = clazz.getDeclaredConstructor(null);

        constructor.setAccessible(true);

        SingleDemo01 instance1a = constructor.newInstance(null);
        // SingleDemo01 instance2a = constructor.newInstance(null);

        System.out.println("---class--->\t" + instance1a);
        // System.out.println("---class--->\t" + instance2a);

    }

    // 反破解测试，
    @Test
    public void testSingletonByPojie2() throws Exception {

        SingleDemo02 instance1 = SingleDemo02.getInstacne();
        SingleDemo02 instance2 = SingleDemo02.getInstacne();

        System.out.println("---class--->\t" + instance1);
        System.out.println("---class--->\t" + instance2);

        @SuppressWarnings("unchecked")
        Class<SingleDemo02> clazz = (Class<SingleDemo02>) Class
                .forName("com.xingej.patterns.singleton.example2.SingleDemo02");

        Constructor<SingleDemo02> constructor = clazz.getDeclaredConstructor(null);

        constructor.setAccessible(true);

        SingleDemo02 instance1a = constructor.newInstance(null);

        SingleDemo02 instance2a = constructor.newInstance(null);

        System.out.println("---class--2->\t" + instance1a);

        System.out.println("---class--2->\t" + instance2a);

    }

}
