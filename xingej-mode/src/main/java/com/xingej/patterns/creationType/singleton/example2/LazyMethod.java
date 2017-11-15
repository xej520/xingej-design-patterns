package com.xingej.patterns.creationType.singleton.example2;

/**
 * 懒汉式；延迟加载；
 * 
 * @author erjun 2017年11月7日 下午7:54:33
 */
public class LazyMethod {
    private static LazyMethod instance;

    private LazyMethod() {

    }

    // 方法同步，调用效率低
    public static synchronized LazyMethod getInstacne() {
        if (null == instance) {
            // 只有使用时，才调用
            instance = new LazyMethod();
        }

        return instance;
    }

}
