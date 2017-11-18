package com.xingej.patterns.structuralType.decorator;

/**
 * 装饰模式
 * 
 * 角色：真实角色的抽象类
 * 
 * @author erjun 2017年11月18日 上午10:16:52
 */
public interface ICar {
    void move();
}

// 创建一个真实角色
class Car implements ICar {

    @Override
    public void move() {
        System.out.println("陆地上跑!");
    }

}
