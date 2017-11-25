package com.xingej.patterns.behaviorPattern.state;

/**
 * 空闲状态
 * 
 * @author erjun 2017年11月25日 上午8:19:43
 */
public class FreeState implements State {

    @Override
    public void handle() {
        System.out.println("空闲状态! 此时没人住");
    }

}
