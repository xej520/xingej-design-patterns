package com.xingej.patterns.structuralType.flyweight;

/**
 * 享元模式
 * 
 * 角色： 外部状态
 * 
 * 特点： 该属性，会随之变化，动态变化的
 * 
 * @author erjun 2017年11月19日 下午3:49:19
 */
public class Coordinate {
    private int x;

    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
