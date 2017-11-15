package com.xingej.patterns.creationType.factory.abstractfactory;

public interface Wheel {
    void showInfo();
}

class LowWheel implements Wheel {
    @Override
    public void showInfo() {
        System.out.println("----我是低级车轮哦----");
    }
}

class HighWheel implements Wheel {
    @Override
    public void showInfo() {
        System.out.println("----我是高级车轮哦-----");
    }
}
