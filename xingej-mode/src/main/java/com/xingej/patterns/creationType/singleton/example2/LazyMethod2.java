package com.xingej.patterns.singleton.example2;

/**
 * 
 * 懒汉式；延迟加载； <<针对破解单例模式，添加了，防止破解方法,
 * 一般情况下，你不需要这样写，如果做项目的话，就不需要考虑，如果是做的产品，如做的是JDK这样的产品的话，就需要了>>
 * 
 * @author erjun 2017年11月8日 下午1:54:50
 */

public class LazyMethod2 {
    private static LazyMethod2 instance;

    // 先类加载，后创建对象，也就是说 先加载类，后调用这个构造方法
    private LazyMethod2() {
        System.out.println("----------1----------------");
        // 添加下面的判断，这样，第一次创建对象时不会报错，第二次创建对象时会报错的
        if (null != instance) {
            System.out.println("----------2----------------");
            throw new RuntimeException();
        }
    }

    // 方法同步，调用效率低
    public static synchronized LazyMethod2 getInstacne() {
        if (null == instance) {
            // 只有使用时，才调用
            instance = new LazyMethod2();
        }

        return instance;
    }

}
