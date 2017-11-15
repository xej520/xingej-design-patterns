package com.xingej.patterns.factory.abstractfactory;

public class HighCarFactory implements CarFactory {

    @Override
    public Engine buildEngine() {
        return new HighEngine();
    }

    @Override
    public Seat buildSeat() {
        return new HighSeat();
    }

    @Override
    public Wheel buildWheel() {
        return new HighWheel();
    }

}
