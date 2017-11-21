package com.xingej.patterns.behaviorPattern.mediator;

import org.junit.Test;

public class MediatorTest {

    @Test
    public void test() {
        Mediator mediator = new President();

        Market market = new Market(mediator);
        Finacial finacial = new Finacial(mediator);
        Development development = new Development(mediator);

        // 市场部 做自己的事情
        market.selfAction();
        finacial.selfAction();// 金融部门做自己的事情
        development.selfAction();// 研发部门做自己的事情

        System.out.println("----------------------------------");
        // ---------开始调用中介者----------

        market.outAction("finacial"); // 市场部，希望调用金融部门
        finacial.outAction("development");// 金融部门，需要研发部门的支持
        development.outAction("market"); // 研发部门，需要市场部门来宣传

        System.out.println("----------------------------------");
        market.outAction("development");

    }

}
