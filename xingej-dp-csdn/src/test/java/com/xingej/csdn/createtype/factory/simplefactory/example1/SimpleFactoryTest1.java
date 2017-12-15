package com.xingej.csdn.createtype.factory.simplefactory.example1;

import org.junit.Test;

/**
 * 简单工厂模式测试
 * 
 * @author erjun 2017年12月15日 下午5:52:13
 */
public class SimpleFactoryTest1 {

    @Test
    public void test1() {
        Chart chart = LowChartFactory.getChart("pie");

        chart.display();

    }

    @Test
    public void test2() {
        Chart chart = LowChartFactory.getChart("line");

        chart.display();

    }

    @Test
    public void test3() {
        Chart chart = LowChartFactory.getChart("histogram");

        chart.display();

    }

    // ---------高级工厂-----验证软件是否具有扩展性-------
    @Test
    public void testByHighChartFactory() {
        // 客户端，调用方，不关心具体的创建过程
        // 只需要知道，
        // 工厂
        // 对象的名字
        // 就可以了
        Chart chart = HighChartFactory.getChart("histogram");

        chart.display();

    }

}
