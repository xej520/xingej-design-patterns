package com.xingej.patterns.structuralType.flyweight;

import org.junit.Test;

/**
 * 
 * 
 * @author erjun 2017年11月19日 下午4:04:12
 */
public class FlyWeightTest {

    @Test
    public void test() {
        ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("黑色");
        ChessFlyWeight chess2 = ChessFlyWeightFactory.getChess("黑色");

        // chess1 与 chess2 共享 颜色 属性
        System.out.println(chess1);
        System.out.println(chess2);

        System.out.println("-----增加外部状态的处理--------");

        chess1.display(new Coordinate(10, 13));
        chess2.display(new Coordinate(40, 33));
    }

}
