package com.xingej.csdn.createtype.factory.simplefactory.example1;

/**
 * 折线图类：具体产品类
 * 
 * @author erjun 2017年12月15日 下午5:39:51
 */
public class LineChart implements Chart {

    public LineChart() {
        System.out.println("----创建折线图！-----");
    }

    @Override
    public void display() {
        System.out.println("显示折线图！");
    }

}
