package com.xingej.csdn.behaviortype.strategyPattern;

import org.junit.Test;

import com.xingej.csdn.utils.XMLUtils;

/**
 * 策略模式
 * 
 * @author erjun 2017年12月22日 下午4:30:05
 */
public class StrategyPatternTest {

    @Test
    public void test() {

        // 是标签名称哦 stategrypattern
        String name = XMLUtils.getName("stategrypattern");

        Discount discount = null;
        try {
            Class clazz = Class.forName("com.xingej.csdn.behaviortype.strategyPattern." + name);

            discount = (Discount) clazz.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }

        MovieTicket movieTicket = new MovieTicket();

        double originalPrice = 60.0;

        movieTicket.setPrice(originalPrice);
        System.out.println("----原始价格----:\t" + originalPrice);
        System.out.println("-----------------------");

        // 注入折扣对象
        movieTicket.setDiscount(discount);

        System.out.println("-----折扣后的价格----:\t" + movieTicket.getPrice());

    }

}
