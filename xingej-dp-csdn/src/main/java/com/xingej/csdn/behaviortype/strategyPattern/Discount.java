package com.xingej.csdn.behaviortype.strategyPattern;

/**
 * 折扣类，抽象策略类
 * 
 * 策略模式的主要目的是将算法的定义与使用分开，也就是将算法的行为和环境分开，
 * 
 * 将算法的定义放在专门的策略类中，每一个策略类封装了一种实现算法，
 * 
 * 使用算法的环境类针对抽象策略类进行编程，符合“依赖倒转原则”
 * 
 * @author erjun 2017年12月22日 下午3:58:14
 */
public interface Discount {
    public double calculate(double price);
}
