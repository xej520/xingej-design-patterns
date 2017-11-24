package com.xingej.patterns.behaviorPattern.observer.example1;

/**
 * 观察者 接口
 * 
 * @author erjun 2017年11月25日 上午7:22:50
 */
public interface Observer {
    // 观察者 更新 自己的API，当然，参数不一定是 被观察者对象
    // 根据实际的业务需求来， 即可
    void update(Subject subject);
}
