package com.xingej.patterns.structuralType.decorator;

/**
 * 装饰模式
 * 
 * 角色：装饰器的接口
 * 
 * 
 * @author erjun 2017年11月18日 上午10:18:48
 */
public class SuperCar implements ICar {

    // 这里必须有，引用；
    // 这是跟 “桥接模式” 实现方式不一样的地方
    protected ICar car;

    public SuperCar(ICar car) {
        super();
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}

// 增加新的功能，水上游
class WaterCar extends SuperCar {

    public WaterCar(ICar car) {
        super(car);
    }

    public void swim() {
        System.out.println("水上游");
    }

    @Override
    public void move() {
        super.move();
        swim();
    }

}

// 增加新的功能, 天上飞
// -------------<如何判断此类是不是装饰器呢？>--------------
// 1、FlyCar 是 ICar的实现类
// 2、构造函数，传入的参数是ICar
class FlyCar extends SuperCar {

    // FlyCar, WaterCar都是ICar的实现类，都可以传进来的
    public FlyCar(ICar car) {
        super(car);
    }

    public void fly() {
        System.out.println("天上飞");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }

}
