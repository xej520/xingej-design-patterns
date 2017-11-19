package com.xingej.patterns.structuralType.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂类
 * 
 * @author erjun 2017年11月19日 下午3:56:25
 */
public class ChessFlyWeightFactory {

    // 享元池
    private static Map<String, ChessFlyWeight> map = new HashMap<>();

    public static ChessFlyWeight getChess(String color) {

        if (null != map.get(color)) {
            return map.get(color);
        } else {
            // 注意，这一块 代码 是线程不安全的
            // 因为可能有多个线程进来，同时创建
            ChessFlyWeight chessFlyweight = new ConcreteChess(color);

            map.put(color, chessFlyweight);

            return chessFlyweight;
        }

    }

}
