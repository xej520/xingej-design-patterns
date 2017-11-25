package com.xingej.patterns.behaviorPattern.state;

/**
 * 已经入住状态
 * 
 * @author erjun 2017年11月25日 上午8:19:43
 */
public class CheckedInState implements State {

    @Override
    public void handle() {
        System.out.println("房间已经入住，请勿打扰!");
    }

}
