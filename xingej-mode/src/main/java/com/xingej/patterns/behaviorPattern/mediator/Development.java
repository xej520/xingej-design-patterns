package com.xingej.patterns.behaviorPattern.mediator;

public class Development implements Department {

    private Mediator mediator;

    public Development(Mediator mediator) {
        this.mediator = mediator;
        // 创建对象时，就注册到中介者里
        mediator.register("development", this);
    }

    @Override
    public void selfAction() {
        System.out.println("研发部：专心科研，研发项目!");
    }

    @Override
    public void outAction(String name) {
        System.out.println("汇报工作，没钱了，需要资金支持!");
        mediator.command(name);
    }

}
