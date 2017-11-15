package com.xingej.patterns.singleton.example1;

/**
 * 单例模式：饿汉式
 * 
 * @author erjun 2017年11月7日 下午7:38:40
 */
public class HungryMethod {

    // static 变量会在类装载时初始化，不会涉及到多线程问题。
    // 虚拟机保证只会装载一次，肯定不会发生并发访问的问题。
    // 因此，可以省略synchronized关键字的
    private static HungryMethod instance = new HungryMethod();

    private HungryMethod() {

    }

    // 问题：如果只是加载了本类，而没有调用getInstance()，甚至永远没有调用，则会造成资源浪费
    public static HungryMethod getInstance() {
        return instance;
    }

}
