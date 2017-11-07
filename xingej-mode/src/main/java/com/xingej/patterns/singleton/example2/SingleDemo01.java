package com.xingej.patterns.singleton.example2;

/**
 * 懒汉式；延迟加载；
 * 
 * @author erjun 2017年11月7日 下午7:54:33
 */
public class SingleDemo01 {
    private static SingleDemo01 instance;

    private SingleDemo01() {

    }

    // 方法同步，调用效率低
    public static synchronized SingleDemo01 getInstacne() {
        if (null == instance) {
            // 只有使用时，才调用
            instance = new SingleDemo01();
        }

        return instance;
    }

}
