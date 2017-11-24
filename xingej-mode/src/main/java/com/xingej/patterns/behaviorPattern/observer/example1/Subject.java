package com.xingej.patterns.behaviorPattern.observer.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题对象(被观察者)
 * 
 * @author erjun 2017年11月23日 下午7:40:08
 */
public class Subject {
    protected List<Observer> list = new ArrayList<>();

    public void registerObserver(Observer observer) {
        list.add(observer);
        System.out.println("---注册完成----:\t");
    }

    public void removeObsever(Observer observer) {
        list.remove(observer);
    }

    // 通知所有的观察者更新状态
    public void notifyAllObserver() {
        for (Observer observer : list) {
            observer.update(this);
        }
    }
}
