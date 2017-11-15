package com.xingej.patterns.creationType.singleton.example4;

/**
 * 静态内部类方式创建单例模式
 * 
 * 第一、当你初始化SingletonDemo01的时候，并不会立即加载静态内部类的。 外部类没有static属性，则不会像饿汉式那样立即加载对象。
 * 第二、只有真正调用getiInstance()，才会加载静态内部类。 第三、 加载类时是线程安全的， instance的类型是static final，
 * 从而保证了内存中只有这样一个实例存在，而且只能被赋值一次， 从而保证了线程安全性 具有高并发和延迟加载的优点
 * 
 * @author erjun 2017年11月8日 上午11:38:31
 */
public class StaticInnerClass {
    // 静态内部类，并不会立即加载的，只有调用时才加载的
    private static class SingletonClassInstance {
        private static final StaticInnerClass instance = new StaticInnerClass();
    }

    private StaticInnerClass() {

    }

    public static StaticInnerClass getInstance() {
        return SingletonClassInstance.instance;
    }

}
