package com.xingej.patterns.creationType.factory.simplefactory;

/**
 * 创建一个简单工厂。简单工厂问题：不能很好的扩展，每次增加新的需求，还要修改代码
 * 
 * @author erjun 2017年11月9日 上午9:13:37
 */
public class CarFactory {

    private static final String BMW = "baoma";
    private static final String AUDI = "audi";

    /**
     * 简单工厂模式：对象的具体创建，交给工厂去完成
     * 
     * @param carType
     *            汽车的类型
     * @return
     */
    public static Car buildCar(String carType) {
        if (BMW.equals(carType)) {

            return new BMW();// 具体的创建对象

        } else if (AUDI.equals(carType)) {

            return new Audi();

        } else {

            return null;
        }
    }

}
