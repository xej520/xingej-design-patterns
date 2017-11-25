package com.xingej.patterns.behaviorPattern.strategy;

/**
 * 新客户少量购买策略
 * 
 * @author erjun 2017年11月25日 上午8:41:19
 */
public class NewCustomerFewsStrategy implements Strategy {

    @Override
    public double getPrice(double standardPrice) {
        System.out.println("不打折，原价!");

        return standardPrice;
    }

}
