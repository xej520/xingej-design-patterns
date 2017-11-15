package com.xingej.patterns.creationType.singleton.example3;

/**
 * 双重检测实现单例模式 //-------不建议使用------此方法哦
 * 
 * @author erjun 2017年11月7日 下午8:08:43
 */
public class DoubleCheck {
    private static DoubleCheck instance;

    private DoubleCheck() {

    }

    // 提高了效率，只是在第一次需要同步；以后就不需要同步了
    // 但是
    // 由于编译器优化原因和JVM底层内部模型元素，偶然会出问题。
    // -------不建议使用------
    public static DoubleCheck getInstance() {
        if (null == instance) {
            synchronized (DoubleCheck.class) {
                if (null == instance) {
                    return instance = new DoubleCheck();
                }
            }
        }

        return instance;
    }
}
