package com.xingej.patterns.behaviorPattern.strategy;

import org.junit.Test;

/**
 * 策略模式
 * 
 * @author erjun 2017年11月25日 上午8:49:41
 */
public class StrategyTest {

    @Test
    public void test() {
        // 创建上下文
        Context context = new Context();

        // 创建一个策略
        Strategy strategy = new OldCustomerFewsStrategy();

        // 注入 策略
        context.setStrategy(strategy);

        context.handlePrices(776);

    }

}
