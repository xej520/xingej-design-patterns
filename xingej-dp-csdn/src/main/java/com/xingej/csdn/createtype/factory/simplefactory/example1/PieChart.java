package com.xingej.csdn.createtype.factory.simplefactory.example1;

/**
 * 饼状图类：具体产品类
 * 
 * @author erjun 2017年12月15日 下午5:39:51
 */
public class PieChart implements Chart {

    public PieChart() {
        System.out.println("----创建饼状图！-----");
    }

    @Override
    public void display() {
        System.out.println("显示饼状图！");
    }

}
