package com.xingej.patterns.singleton.example5;

/**
 * 枚举的方式 实现 单例模式
 * 
 * 《优点》： 1、实现简单；2、枚举类本身就是单例模式，由JVM从根本上提供保障。避免通过反射和反序列化的漏洞进行创建实例对象 。《缺点》：无延迟加载
 * 
 * 
 * @author erjun 2017年11月8日 上午11:53:40
 */
public enum SingletoDemo01 {
    INSTANCE;

    public void show() {
        System.out.println("----我是枚举类型的单例模式哦------");
    }

    // 测试用例
    public static void main(String[] args) {
        SingletoDemo01 aDemo01 = SingletoDemo01.INSTANCE;
        SingletoDemo01 bDemo01 = SingletoDemo01.INSTANCE;

        // 校验是否是同一个对象
        System.out.println(aDemo01 == bDemo01);
    }
}
