package com.xingej.patterns.structuralType.flyweight;

import org.junit.Test;

/**
 * 不使用享元模式
 * 
 * @author erjun 2017年11月19日 下午4:06:39
 */

public class NoFlyWeightTest {

    @Test
    public void test() {

        ChessTest redChess1 = new ChessTest("红色", 10, 10);
        ChessTest redChess2 = new ChessTest("红色", 11, 10);
        ChessTest redChess3 = new ChessTest("红色", 12, 10);
        ChessTest redChess4 = new ChessTest("红色", 14, 10);

        // 这里有个问题
        // 观察这些属性，color 是可以内容共享的
        // 而，x,y 始终不一样

        // 可以将红色属性 提炼出来，节省内存

    }
}
