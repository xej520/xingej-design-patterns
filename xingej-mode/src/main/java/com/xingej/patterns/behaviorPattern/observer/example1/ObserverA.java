package com.xingej.patterns.behaviorPattern.observer.example1;

/**
 * 具体的观察者
 * 
 * @author erjun 2017年11月25日 上午7:34:53
 */
public class ObserverA implements Observer {

    private int myState;

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }

    @Override
    public void update(Subject subject) {
        myState = ((ConcreteSubject) subject).getState();
    }

}
