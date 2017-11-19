package com.xingej.patterns.structuralType.flyweight;

/**
 * 享元模式
 * 
 * 角色： 内部状态， 具体的角色
 * 
 * 特点：属性稳定不变，多个实例对象共享此属性
 * 
 * @author erjun 2017年11月19日 下午3:52:11
 */
public class ConcreteChess implements ChessFlyWeight {

    // 为内部状态提供成员变量 进行 存储
    private String color;

    public ConcreteChess(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void display(Coordinate coordinate) {
        System.out.println("棋子颜色:\t" + color);

        System.out.println("棋子位置:\t" + coordinate.getX() + coordinate.getY());

    }

}
