package com.xingej.patterns.behaviorPattern.strategy;

/**
 * 新客户大量购买策略
 * 
 * @author erjun 2017年11月25日 上午8:41:19
 */
public class NewCustomeManyStrategy implements Strategy {

    @Override
    public double getPrice(double standardPrice) {
        System.out.println("打9折");

        return standardPrice * 0.9;
    }

}
