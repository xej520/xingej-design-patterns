package com.xingej.patterns.behaviorPattern.mediator;

public class Market implements Department {

    private Mediator mediator;

    public Market(Mediator mediator) {
        this.mediator = mediator;
        // 创建对象时，就注册到中介者里
        mediator.register("market", this);
    }

    @Override
    public void selfAction() {
        System.out.println("市场部： 承接项目!");
    }

    @Override
    public void outAction(String name) {
        System.out.println("汇报工作，项目承接的进度，需要资金支持!");
        mediator.command(name);
    }

}
