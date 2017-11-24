package com.xingej.patterns.behaviorPattern.observer.example2;

import java.util.Observable;

/**
 * 观察者模式：使用JDK自带的工具类
 * 
 * Observable 就相当于 你写的Subject
 * 
 * @author erjun 2017年11月25日 上午7:45:03
 */
public class JDKConcreteSubject extends Observable {
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;

        // 表示目标对象已经更改了
        // 下面这条语句，一定要添加，不然后面的notifyObservers 不会生效的
        setChanged();

        // 通知所有的观察者
        notifyObservers(state);
    }

}
