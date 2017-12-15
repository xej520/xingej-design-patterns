package com.xingej.csdn.createtype.factory.simplefactory.example1;

/**
 * 柱状图类：具体产品类
 * 
 * @author erjun 2017年12月15日 下午5:39:51
 */
public class HistogramChart implements Chart {

    public HistogramChart() {
        System.out.println("----创建柱状图！-----");
    }

    @Override
    public void display() {
        System.out.println("显示柱状图！");
    }

}
