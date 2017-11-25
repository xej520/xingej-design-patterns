package com.xingej.patterns.behaviorPattern.strategy;

/**
 * 负责和具体的策略类交互
 * 
 * 这样的话，具体的算法和直接客户端调用分离，
 * 
 * 使得算法可以独立与客户端独立的变化
 * 
 * 如果使用spring的依赖注入功能，还可以通过配置文件，动态的注入不同策略对象，动态的切换不同的算法
 * 
 * @author erjun 2017年11月25日 上午8:44:56
 */
public class Context {
    private Strategy strategy;

    public Context() {
    }

    // 通过构造器来注入
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    // 通过set方法来注入
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void handlePrices(double standardPrice) {
        System.out.println("您该报价:\t" + strategy.getPrice(standardPrice));
    }

}
