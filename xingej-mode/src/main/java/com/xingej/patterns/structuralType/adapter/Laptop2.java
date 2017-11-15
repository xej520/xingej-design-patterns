package com.xingej.patterns.adapter;

/**
 * 角色：调用方
 * 
 * 调用方，如何获取适配器呢？
 * 
 * A、通过参数输入，如Laptop.java里
 * 
 * B、通过对象组合的方式，如下面介绍
 * 
 * @author erjun 2017年11月14日 下午7:58:57
 */
public class Laptop2 {
    private IAdapter adapter;

    public Laptop2(IAdapter adapter) {
        this.adapter = adapter;
    }

    public void processKey() {
        adapter.handle();
    }
}
