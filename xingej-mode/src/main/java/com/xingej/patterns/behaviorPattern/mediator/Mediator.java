package com.xingej.patterns.behaviorPattern.mediator;

/**
 * 中介者接口
 * 
 * 中介者模式要点：
 * 
 * 需要两个角色：中介者，具体抽象类
 * 
 * 中介者接口里，1、需要注册(用来存在其他组件)，2、调用其他组件的功能
 * 
 * 具体抽象者：1、需要有中介者的引用；2、有专门属于自己的行为API 如selfAction， 也有调用中介者的API，如outAction
 * 
 * @author erjun 2017年11月21日 下午1:43:22
 */
public interface Mediator {
    // 注册
    void register(String name, Department department);

    // 调用其他组件
    void command(String name);
}
