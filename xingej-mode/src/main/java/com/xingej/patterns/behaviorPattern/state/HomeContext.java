package com.xingej.patterns.behaviorPattern.state;

/**
 * 房间上下文
 * 
 * @author erjun 2017年11月25日 上午8:22:31
 */
public class HomeContext {
    private State state;

    public void setState(State state) {
        System.out.println("修改状态!");
        this.state = state;

        // 当切换到不同的状态时，会调用不同的行为
        state.handle();
    }

}
