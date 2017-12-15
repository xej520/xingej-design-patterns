package com.xingej.csdn.createtype.factory.simplefactory.example1;

import com.xingej.csdn.utils.XMLUtils;

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

    // 不需要输入参数，由配置文件，来进行指定
    public static Chart getChart() {

        // 读取配置里的配置
        String type = XMLUtils.getChartType();

        // 将第一个字母，转换成大写
        // 下面这种写法，有点笨
        // type = type.replace(type.charAt(0),
        // String.valueOf(type.charAt(0)).toUpperCase().charAt(0));

        type = type.substring(0, 1).toUpperCase() + type.substring(1);

        // 添加后缀，就是类名了，如HistogramChart了
        String clazz = type + "Chart";

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
