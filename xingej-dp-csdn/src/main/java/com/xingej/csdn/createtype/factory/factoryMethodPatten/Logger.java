package com.xingej.csdn.createtype.factory.factoryMethodPatten;

/**
 * 产品的接口
 * 
 * 工厂方法模式的核心：
 * 
 * 在工厂方法模式中，我们不再提供一个统一的工厂类来创建所有的产品对象，而是针对不同的产品提供不同的工厂，
 * 
 * 系统提供一个与产品登记结构对应的工厂等级结构
 * 
 * @author erjun 2017年12月21日 上午10:19:49
 */
public interface Logger {
    void show();
}
