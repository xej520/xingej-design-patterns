package com.xingej.patterns.behaviorPattern.strategy;

/**
 * 老客户大量购买策略
 * 
 * @author erjun 2017年11月25日 上午8:41:19
 */
public class OldCustomerManyStrategy implements Strategy {

    @Override
    public double getPrice(double standardPrice) {
        System.out.println("8折!");

        return standardPrice * 0.8;
    }

}
