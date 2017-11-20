package com.xingej.patterns.behaviorPattern.responsibilityChainModel;

import org.junit.Test;

/**
 * 责任链模式测试
 * 
 * @author erjun 2017年11月20日 下午2:09:36
 */
public class RCMTest {

    // 责任链模式的好处：
    // 组织关系，可以写到配置文件里
    // 可以在客户端这边定义

    // 扩展性很好，
    // 这种业务逻辑虽然if else也可以完成，但是，扩展性不好，必须要修改源代码
    @Test
    public void test() {
        Leader director = new Director("张三");
        Leader manager = new Manager("李四");
        Leader generalManager = new GeneralManager("王五 ");

        // 设定 组织责任链对象的关系
        director.setNextLeader(manager);
        manager.setNextLeader(generalManager);

        // 开始请假操作
        LeaveRequest reql = new LeaveRequest("Jack", 10, "生病!");

        director.handleRequest(reql);

    }

    // 扩展性测试，
    // 假如，增加一个副总经理
    @Test
    public void test2() {
        Leader director = new Director("张三");
        Leader manager = new Manager("李四");
        Leader viceGeneralManager = new ViceGeneralManager("二麻子");
        Leader generalManager = new GeneralManager("王五 ");

        // 设定 组织责任链对象的关系
        director.setNextLeader(manager);
        manager.setNextLeader(viceGeneralManager);
        viceGeneralManager.setNextLeader(generalManager);

        // 开始请假操作
        LeaveRequest reql = new LeaveRequest("Jack", 2, "生病!");
        LeaveRequest reql2 = new LeaveRequest("Tom", 15, "去杭州旅游");
        LeaveRequest reql3 = new LeaveRequest("Lili", 25, "购物!");

        director.handleRequest(reql);
        director.handleRequest(reql2);
        director.handleRequest(reql3);

    }

}
