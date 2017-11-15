package com.xingej.patterns.factory.factoryfunction;

import org.junit.Test;

/**
 * 工厂方法模式测试
 * 
 * @author erjun 2017年11月9日 上午10:45:23
 */
public class FactoryFunction {

    @Test
    public void testFactoryFunction() {
        // 创建一个Audi车
        Car audi = new AudiCarFactory().buildCar();

        // 再创建一个宝马车
        Car baoma = new BMWCarFactory().buildCar();

        audi.run();
        baoma.run();

    }

}
