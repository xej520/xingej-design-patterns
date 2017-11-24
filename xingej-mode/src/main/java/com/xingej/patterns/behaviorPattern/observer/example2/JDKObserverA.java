package com.xingej.patterns.behaviorPattern.observer.example2;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式：JDK自带的工具类
 * 
 * @author erjun 2017年11月25日 上午7:46:38
 */
public class JDKObserverA implements Observer {

    private int myState;

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }

    // 参数Observable 是主题对象的父类
    @Override
    public void update(Observable o, Object arg) {
        myState = ((JDKConcreteSubject) o).getState();
        System.out.println("====:\t" + myState);
    }

}
