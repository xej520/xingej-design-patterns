package com.xingej.patterns.creationType.factory.factoryfunction;

/**
 * 工厂方法模式，
 * 
 * 优点：有利于扩展，当有新的需求时，不需要修改原代码
 * 
 * 缺点: 增加了调用者的使用难度，调用者不光要知道工厂，还要知道工厂的具体实现类
 * 
 * 因此，一般情况下，还是使用简单工厂模式
 * 
 * @author erjun 2017年11月9日 上午10:41:02
 */
public interface CarFactory {
    Car buildCar();
}
