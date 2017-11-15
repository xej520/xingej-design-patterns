package com.xingej.patterns.factory.abstractfactory;

/**
 * 定义了一批产品组
 * 
 * @author erjun 2017年11月9日 下午1:49:33
 */

public interface CarFactory {
    Engine buildEngine();

    Seat buildSeat();

    Wheel buildWheel();
}
