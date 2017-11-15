package com.xingej.patterns.creationType.factory.abstractfactory;

public interface Engine {
    void show();
}

class HighEngine implements Engine {

    @Override
    public void show() {
        System.out.println("----我是高级引擎哦----");
    }

}

class LowEngine implements Engine {

    @Override
    public void show() {
        System.out.println("---我是低级引擎哦----");
    }

}