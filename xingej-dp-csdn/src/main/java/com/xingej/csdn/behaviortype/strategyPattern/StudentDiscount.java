package com.xingej.csdn.behaviortype.strategyPattern;

/**
 * 学生票折扣类：具体策略类
 * 
 * @author erjun 2017年12月22日 下午3:59:24
 */
public class StudentDiscount implements Discount {

    @Override
    public double calculate(double price) {

        System.out.println("----学生票----");

        return price * 0.8;
    }

}
