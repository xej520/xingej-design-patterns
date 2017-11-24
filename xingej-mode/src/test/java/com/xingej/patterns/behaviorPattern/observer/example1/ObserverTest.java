package com.xingej.patterns.behaviorPattern.observer.example1;

import org.junit.Test;

/**
 * 自己实观察模式
 * 
 * @author erjun 2017年11月25日 上午7:28:59
 */
public class ObserverTest {

    @Test
    public void test() {
        // 创建目标对象
        ConcreteSubject subject = new ConcreteSubject();

        // 创建多个观察者
        ObserverA obs1 = new ObserverA();
        ObserverA obs2 = new ObserverA();
        ObserverA obs3 = new ObserverA();

        // 将观察者 设置到 subject对象的观察者 容器中
        subject.registerObserver(obs1);
        subject.registerObserver(obs2);
        subject.registerObserver(obs3);

        // 改变subject的状态
        subject.setState(4000);
        System.out.println("-----------------");
        // 查看，观察者的状态是否发生了变化
        System.out.println("---->:\t" + obs1.getMyState());
        System.out.println("---->:\t" + obs2.getMyState());
        System.out.println("---->:\t" + obs3.getMyState());

    }

}
