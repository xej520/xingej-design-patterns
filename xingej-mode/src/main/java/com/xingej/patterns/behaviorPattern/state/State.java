package com.xingej.patterns.behaviorPattern.state;

/**
 * 状态模式
 * 
 * 核心：就是用来解决系统中复杂对象的状态转换 以及 不同状态下 行为的封装问题
 * 
 * 结构：
 * 
 * Context环境类：维护一个State对象，它是定义了当前的状态
 * 
 * State 抽象状态类
 * 
 * ConcreteState具体状态类，每一个类封装了一个状态对应的行为
 * 
 * 场景：线程对象各种状态之间的转换，酒店系统中，房间状态的管理；OA系统中公文状态的管理；银行系统中账号状态的管理
 * 
 * @author erjun 2017年11月25日 上午8:17:25
 */
public interface State {
    void handle();
}
