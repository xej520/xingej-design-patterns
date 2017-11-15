package com.xingej.patterns.factory.abstractfactory;

public class LowCarFactory implements CarFactory {

    @Override
    public Engine buildEngine() {
        return new LowEngine();
    }

    @Override
    public Seat buildSeat() {
        return new LowSeat();
    }

    @Override
    public Wheel buildWheel() {
        return new LowWheel();
    }

}
