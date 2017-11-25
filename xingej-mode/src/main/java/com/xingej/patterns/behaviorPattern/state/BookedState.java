package com.xingej.patterns.behaviorPattern.state;

/**
 * 已预订状态
 * 
 * @author erjun 2017年11月25日 上午8:19:43
 */
public class BookedState implements State {

    @Override
    public void handle() {
        System.out.println("房间已经预订状态!");
    }

}
