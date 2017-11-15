package com.xingej.patterns.singleton.example4;

import java.io.Serializable;

/**
 * 测试 通过 反序列化的方式，来破解单例模式
 * 
 * @author erjun 2017年11月8日 下午3:41:29
 */
public class StaticInnerClass2 implements Serializable {

    private static final long serialVersionUID = 1L;

    // 静态内部类，并不会立即加载的，只有调用时才加载的
    private static class SingletonClassInstance {
        private static final StaticInnerClass2 instance = new StaticInnerClass2();
    }

    private StaticInnerClass2() {

    }

    public static StaticInnerClass2 getInstance() {
        return SingletonClassInstance.instance;
    }

    // 反序列化时，自动调用这个方法的
    // 直接返回对象，不需要再单独创建新的对象了

    // 使用下面的方式，就可以
    // 阻止，通过序列化的方式来破解单例模式
    private Object readResolve() {
        return SingletonClassInstance.instance;
    }

}
