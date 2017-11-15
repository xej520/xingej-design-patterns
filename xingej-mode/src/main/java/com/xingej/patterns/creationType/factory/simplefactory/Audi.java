package com.xingej.patterns.creationType.factory.simplefactory;

/**
 * 创建奥迪类
 * 
 * @author erjun 2017年11月9日 上午9:03:35
 */

public class Audi implements Car {

    @Override
    public void run() {
        System.out.println("--->我是奥迪哦<----");
    }

}
