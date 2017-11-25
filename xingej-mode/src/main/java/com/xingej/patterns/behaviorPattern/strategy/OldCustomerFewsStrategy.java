package com.xingej.patterns.behaviorPattern.strategy;

/**
 * 老客户少量购买策略
 * 
 * @author erjun 2017年11月25日 上午8:41:19
 */
public class OldCustomerFewsStrategy implements Strategy {

    @Override
    public double getPrice(double standardPrice) {
        System.out.println("85折!");

        return standardPrice * 0.85;
    }

}
