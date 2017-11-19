package com.xingej.patterns.structuralType.flyweight;

/**
 * 抽象享元类
 * 
 * @author erjun 2017年11月19日 下午4:13:09
 */
public interface ChessFlyWeight {
    String getColor();

    void display(Coordinate coordinate);
}
