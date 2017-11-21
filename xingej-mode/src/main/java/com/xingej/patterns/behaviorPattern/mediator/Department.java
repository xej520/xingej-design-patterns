package com.xingej.patterns.behaviorPattern.mediator;

/**
 * 组件接口
 * 
 * @author erjun 2017年11月21日 下午1:42:38
 */
public interface Department {
    // 自己行为API，当然，这是一类方法，可能会有很多的
    void selfAction();

    // 调用中介者的API
    void outAction(String name);
}
