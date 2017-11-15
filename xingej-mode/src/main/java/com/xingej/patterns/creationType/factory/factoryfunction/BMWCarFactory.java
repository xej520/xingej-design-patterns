package com.xingej.patterns.factory.factoryfunction;

/**
 * 宝马工厂
 * 
 * @author erjun 2017年11月9日 上午10:43:31
 */

public class BMWCarFactory implements CarFactory {

    @Override
    public Car buildCar() {
        return new BMW();
    }

}
