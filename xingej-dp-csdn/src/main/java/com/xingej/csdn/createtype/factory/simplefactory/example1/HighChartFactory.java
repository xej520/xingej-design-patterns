package com.xingej.csdn.createtype.factory.simplefactory.example1;

/**
 * 升级版的工厂
 * 
 * 进步点：使用了反射的方式，有利于扩展；
 * 
 * 如果有新的业务时，不需要更新这里的代码。满足面向对象设计的开闭原则
 * 
 * @author erjun 2017年12月16日 上午5:53:04
 */
public class HighChartFactory {

    public static Chart getChart(String type) {

        // 就是将第一个字母大写
        // 替换第一个字母
        String clazz = type.replace(type.charAt(0), String.valueOf(type.charAt(0)).toUpperCase().charAt(0)) + "Chart";

        Chart chart = null;

        try {
            chart = (Chart) Class.forName("com.xingej.csdn.createtype.factory.simplefactory.example1." + clazz)
                    .newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return chart;
    }

}
