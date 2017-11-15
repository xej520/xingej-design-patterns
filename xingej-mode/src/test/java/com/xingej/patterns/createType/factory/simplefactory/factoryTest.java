package com.xingej.patterns.createType.factory.simplefactory;

import org.junit.Test;

import com.xingej.patterns.creationType.factory.simplefactory.Audi;
import com.xingej.patterns.creationType.factory.simplefactory.BMW;
import com.xingej.patterns.creationType.factory.simplefactory.Car;
import com.xingej.patterns.creationType.factory.simplefactory.CarFactory;

/**
 * 工厂模式测试
 * 
 * @author erjun 2017年11月9日 上午9:04:33
 */

public class factoryTest {

    // 不使用工厂模式，看看怎么创建对象，会存在什么问题
    // 这种模式存在的问题
    // 调用者必须知道，接口，以及接口的实现类,甚至参数

    // 增加了使用者的调度难度
    // 站在调用者的角度，我需要什么对象，你给我就可以了，具体的创建，如何创建，怎么创建，
    // 我根本不关心
    @Test
    public void testNoFactory() {
        // 创建宝马对象
        Car bmw = new BMW();

        // 创建奥迪对象
        Car audi = new Audi();

        bmw.run();
        audi.run();

    }

    // 简单工厂模式
    @Test
    public void testSimpleFactory() {
        // 创建宝马对象,通过具体的工厂去创建，调用者/使用者自己不再具体的负责了
        Car bmw = CarFactory.buildCar("baoma");

        // 创建奥迪对象
        Car audi = CarFactory.buildCar("audi");

        bmw.run();
        audi.run();
    }

}
