package com.xingej.patterns.structuralType.decorator;

import org.junit.Test;

/**
 * 装饰器模式测试
 * 
 * 总结：
 * 
 * ICar 抽象的真实角色
 * 
 * car 是具体的真实角色
 * 
 * SuperCar 装饰器的父类
 * 
 * WaterCar, FlyCar 都是具体的装饰器
 * 
 * 如何编写：
 * 
 * 1、先编写"抽象的真实角色"；2、再编写 装饰器的父类，要求实现ICar, 并且有ICar的引用
 * 
 * @author erjun 2017年11月18日 上午10:25:44
 */
public class DecoratorTest {

    // 创建一个普通的汽车
    @Test
    public void test() {
        ICar car = new Car();
        car.move();

    }

    // 普通车上，增加新功能：水上游
    @Test
    public void testWater() {
        ICar car = new Car();

        // 往 装饰器 里 传入的 真实的角色
        WaterCar waterCar = new WaterCar(car);

        waterCar.move();
    }

    // 普通车上，增加新功能：天上飞
    @Test
    public void testFly() {
        ICar car = new Car();

        FlyCar flyCar = new FlyCar(car);

        flyCar.move();
    }

    // 普通车上，增加新功能：天上飞, 水上游
    @Test
    public void testFlyAndWater() {
        ICar car = new Car();

        // FlyCar, WaterCar都是ICar的实现类，都可以传进来的
        // 往 装饰器 里，传入 另一个装饰器
        FlyCar flyCar = new FlyCar(new WaterCar(car));

        flyCar.move();
    }

}
