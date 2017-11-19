package com.xingej.patterns.structuralType.flyweight;

/**
 * 如果不使用
 * 
 * 享元模式的话，
 * 
 * 需要这样设计
 * 
 * @author erjun 2017年11月19日 下午4:04:41
 */
public class ChessTest {
    // 许多实例，会有相同的颜色，因此，这个可以设置为内部状态
    private String color;

    private int x;

    private int y;

    public ChessTest(String color, int x, int y) {
        this.color = color;

        this.x = x;

        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
