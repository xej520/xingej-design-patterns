package com.xingej.patterns.creationType.factory.simplefactory;

/**
 * 创建宝马类
 * 
 * @author erjun 2017年11月9日 上午9:03:06
 */
public class BMW implements Car {

    @Override
    public void run() {
        System.out.println("---->我是宝马<----");
    }

}
