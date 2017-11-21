package com.xingej.patterns.behaviorPattern.mediator;

public class Finacial implements Department {

    private Mediator mediator;

    public Finacial(Mediator mediator) {
        this.mediator = mediator;
        // 创建对象时，就注册到中介者里
        mediator.register("finacial", this);
    }

    @Override
    public void selfAction() {
        System.out.println("金融部：数钱!");
    }

    @Override
    public void outAction(String name) {
        System.out.println("汇报工作，钱太多，怎么花!");
        mediator.command(name);
    }

}
