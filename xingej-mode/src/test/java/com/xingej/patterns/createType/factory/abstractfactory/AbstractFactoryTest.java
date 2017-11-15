package com.xingej.patterns.createType.factory.abstractfactory;

import org.junit.Test;

import com.xingej.patterns.creationType.factory.abstractfactory.CarFactory;
import com.xingej.patterns.creationType.factory.abstractfactory.Engine;
import com.xingej.patterns.creationType.factory.abstractfactory.HighCarFactory;
import com.xingej.patterns.creationType.factory.abstractfactory.Seat;
import com.xingej.patterns.creationType.factory.abstractfactory.Wheel;

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
