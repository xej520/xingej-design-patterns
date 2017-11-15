package com.xingej.patterns.structuralType.adapter;

/**
 * 适配器(类适配器方式)
 * 
 * 就是通过继承 "被调用方"来实现
 * 
 * @author erjun 2017年11月14日 下午7:16:16
 */
public class Adapter1 extends OldKeyboard implements IAdapter {

    @Override
    public void handle() {
        // 直接调用父类的 打字功能即可
        super.daziFunction();
    }

}
