package com.xingej.patterns.adapter;

/**
 * 适配器(对象组合方式的适配器)
 * 
 * @author erjun 2017年11月14日 下午7:45:37
 */
public class Adapter2 implements IAdapter {

    // 这属于 对象组合方式
    private OldKeyboard oldKeyboard;

    public Adapter2(OldKeyboard oldKeyboard) {
        this.oldKeyboard = oldKeyboard;
    }

    @Override
    public void handle() {
        oldKeyboard.daziFunction();
    }

}
