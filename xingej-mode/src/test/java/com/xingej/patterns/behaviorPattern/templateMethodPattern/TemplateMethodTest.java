package com.xingej.patterns.behaviorPattern.templateMethodPattern;

import org.junit.Test;

/**
 * 模板方法模式测试
 * 
 * @author erjun 2017年11月22日 下午7:03:36
 */
public class TemplateMethodTest {

    @Test
    public void test() {
        // 使用内部类实现，
        // 当然，也可以使用 定义一个具体的普通类实现
        BankTemplateMethod bt = new BankTemplateMethod() {

            @Override
            public void transact() {
                System.out.println("取钱业务！");
            }
        };

        bt.process();

    }

    @Test
    public void test2() {
        // 使用内部类实现，
        // 当然，也可以使用 定义一个具体的普通类实现
        BankTemplateMethod bt = new BankTemplateMethod() {

            @Override
            public void transact() {
                System.out.println("存钱业务！");
            }
        };

        bt.process();

    }

}
