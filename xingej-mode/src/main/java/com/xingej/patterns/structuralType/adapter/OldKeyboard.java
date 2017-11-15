package com.xingej.patterns.structuralType.adapter;

/**
 * 练习：适配器模式
 * 
 * 角色： 被调用方
 * 
 * 背景：旧时键盘，跟现代的笔记本接口不匹配，因此，不能直接被调用，需要一个适配器才可以的
 * 
 * @author erjun 2017年11月14日 下午7:11:26
 */
public class OldKeyboard {

    public void daziFunction() {
        System.out.println("---我是键盘侠，具有打字功能哦------");
    }

}
