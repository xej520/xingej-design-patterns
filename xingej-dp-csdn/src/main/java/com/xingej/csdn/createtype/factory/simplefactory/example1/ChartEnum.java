package com.xingej.csdn.createtype.factory.simplefactory.example1;

/**
 * 枚举：定义图表常量的
 * 
 * @author erjun 2017年12月15日 下午5:43:47
 */
public enum ChartEnum {
    HistogramChart("histogram"), LineChart("line"), PieChart("pie");

    public String type;

    private ChartEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
