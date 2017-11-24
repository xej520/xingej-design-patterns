package com.xingej.patterns.behaviorPattern.observer.example2;

import org.junit.Test;

public class ObserverTest {

    @Test
    public void test() {
        // 创建目标对象
        JDKConcreteSubject subject = new JDKConcreteSubject();

        // 创建多个观察者
        JDKObserverA obs1 = new JDKObserverA();
        JDKObserverA obs2 = new JDKObserverA();
        JDKObserverA obs3 = new JDKObserverA();

        // 将观察者 设置到 subject对象的观察者 容器中
        subject.addObserver(obs1);
        subject.addObserver(obs2);
        subject.addObserver(obs3);

        // 改变subject的状态
        subject.setState(4000);
        System.out.println("-----------------");
        // 查看，观察者的状态是否发生了变化
        System.out.println("---->:\t" + obs1.getMyState());
        System.out.println("---->:\t" + obs2.getMyState());
        System.out.println("---->:\t" + obs3.getMyState());

    }

}
