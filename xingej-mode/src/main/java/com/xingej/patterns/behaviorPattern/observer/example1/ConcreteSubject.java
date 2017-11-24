package com.xingej.patterns.behaviorPattern.observer.example1;

/**
 * 具体的主题对象（被观察者）
 * 
 * @author erjun 2017年11月25日 上午7:25:34
 */
public class ConcreteSubject extends Subject {
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;

        // 主题对象(目标对象)值发生变化后，就主动通知所有的观察者
        // 这种模式输入
        // PUSH模式
        this.notifyAllObserver();
    }

}
