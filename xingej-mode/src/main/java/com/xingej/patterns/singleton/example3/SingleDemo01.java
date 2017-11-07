package com.xingej.patterns.singleton.example3;

/**
 * 双重检测实现单例模式 //-------不建议使用------此方法哦
 * 
 * @author erjun 2017年11月7日 下午8:08:43
 */
public class SingleDemo01 {
    private static SingleDemo01 instance;

    private SingleDemo01() {

    }

    // 提高了效率，只是在第一次需要同步；以后就不需要同步了
    // 但是
    // 由于编译器优化原因和JVM底层内部模型元素，偶然会出问题。
    // -------不建议使用------
    public static SingleDemo01 getInstance() {
        if (null == instance) {
            synchronized (SingleDemo01.class) {
                if (null == instance) {
                    return instance = new SingleDemo01();
                }
            }
        }

        return instance;
    }
}
