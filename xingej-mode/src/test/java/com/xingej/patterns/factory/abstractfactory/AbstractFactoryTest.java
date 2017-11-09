package com.xingej.patterns.factory.abstractfactory;

import org.junit.Test;

public class AbstractFactoryTest {

    @Test
    public void testAbstractFactory() {

        CarFactory factory = new HighCarFactory();

        Engine highEngine = factory.buildEngine();

        highEngine.show();

        Seat highSeat = factory.buildSeat();
        highSeat.say();

        Wheel highWheel = factory.buildWheel();
        highWheel.showInfo();

    }

}
