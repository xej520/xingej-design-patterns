package com.xingej.patterns.structuralType.adapter;

/**
 * 练习：适配器模式
 * 
 * 角色：调用方
 * 
 * @author erjun 2017年11月14日 下午7:09:03
 */
public class Laptop {

    // 通过适配器，来调用 被调用方
    public void processKey(IAdapter adapter) {
        adapter.handle();
    }
}
