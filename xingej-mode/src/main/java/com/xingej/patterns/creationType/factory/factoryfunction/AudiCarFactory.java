package com.xingej.patterns.factory.factoryfunction;

/**
 * 专门为Audi车 创建一个工厂，专门用来创建Audi
 * 
 * @author erjun 2017年11月9日 上午10:42:52
 */
public class AudiCarFactory implements CarFactory {

    @Override
    public Car buildCar() {
        return new Audi();
    }

}
