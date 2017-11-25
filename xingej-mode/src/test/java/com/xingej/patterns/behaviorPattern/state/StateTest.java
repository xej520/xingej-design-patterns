package com.xingej.patterns.behaviorPattern.state;

import org.junit.Test;

/**
 * 状态模式
 * 
 * @author erjun 2017年11月25日 上午8:25:06
 */
public class StateTest {

    @Test
    public void test() {
        // 创建一个上下文
        HomeContext context = new HomeContext();

        // 创建一个 状态
        FreeState freeState = new FreeState();

        // 将此状态，更新到上下文中
        context.setState(freeState);
    }

}
