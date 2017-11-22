package com.xingej.patterns.behaviorPattern.templateMethodPattern;

/**
 * 模板方法模式
 * 
 * 核心：处理某个流程的代码已经有了，但是其中某个节点的代码暂时不能确定。
 * 
 * 也就是说，处理步骤父类已经定义好了，具体的实现有子类去实现
 * 
 * @author erjun 2017年11月22日 下午6:57:34
 */
public abstract class BankTemplateMethod {
    // 具体方法
    public void takeNumber() {
        System.out.println("取号排队!");
    }

    // 办理具体的办法； 钩子方法
    // 抽象方法，具体是由子类去实现
    public abstract void transact();

    public void evaluate() {
        System.out.println("反馈评分!");
    }

    // 定义好 业务处理流程
    // final 子类不能重写
    public final void process() {
        takeNumber();

        transact();

        evaluate();
    }

}
