package com.xingej.patterns.factory.abstractfactory;

public interface Seat {
    void say();
}

class LowSeat implements Seat {
    @Override
    public void say() {
        System.out.println("----我是低级的车座哦-----");
    }
}

class HighSeat implements Seat {

    @Override
    public void say() {
        System.out.println("---我是高级的车座哦-----");
    };

}
