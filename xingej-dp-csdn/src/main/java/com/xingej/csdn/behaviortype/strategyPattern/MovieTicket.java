package com.xingej.csdn.behaviortype.strategyPattern;

/**
 * 电影票类，环境类
 * 
 * @author erjun 2017年12月22日 下午4:03:17
 */
public class MovieTicket {
    private double price;

    private Discount discount; // 维持一个对象折扣类的引用

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double getPrice() {
        // 调用折扣类的折扣价计算方法
        return discount.calculate(this.price);
    }

}
