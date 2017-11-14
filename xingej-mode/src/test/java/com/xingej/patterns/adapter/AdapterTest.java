package com.xingej.patterns.adapter;

import org.junit.Test;

/**
 * 适配器 模式 测试
 * 
 * 总结：
 * 
 * 1、首先搞清楚，谁是调用方(Laptop)，谁是被调用方(OldKeyboad)
 * 
 * 2、 编写适配器接口(IAdapter)
 * 
 * 3、在调用方，编写API(processKey())， 参数是适配器
 * 
 * 4、实现适配器接口，有两种形式，一种是继承被调用方法，另一种是对象组合方式
 * 
 * 
 * @author erjun 2017年11月14日 下午7:18:18
 */
public class AdapterTest {

    // 类适配器 方式 测试
    // 调用方，只需要跟 适配器 打交道即可了
    @Test
    public void testByClassAdapter() {
        // 创建 调用方， 笔记本电脑
        Laptop laptop = new Laptop();

        // 创建一个 适配器
        IAdapter adapter = new Adapter1();

        // 调用方，要调用 被调用方法，也就是
        // 笔记本 要调用 键盘了
        laptop.processKey(adapter);

    }

    // 对象组合方式的适配器
    // 适配器 Adapter2 更加灵活，
    // 但是，增加了调用方的难度，因为，如果使用类适配器方式的话，只需要知道适配器就可以了
    // 现在，调用方，还要知道被调用方法，需要创建
    // 因此，类适配器方式 与 对象适配器方式 各有各的优缺点吧
    @Test
    public void testByObjectAdapter() {
        // 创建 调用方， 笔记本电脑
        Laptop laptop = new Laptop();

        // 创建一个 适配器，
        // 参数为 被调用方对象实例
        IAdapter adapter = new Adapter2(new OldKeyboard());

        // 调用方，要调用 被调用方法，也就是
        // 笔记本 要调用 键盘了
        laptop.processKey(adapter);

    }

    // 测试调用方，通过对象的组合的方式，来获取适配器
    // 也可以通过传入参数的方式来获取
    @Test
    public void testByLaptop() {
        Laptop2 laptop2 = new Laptop2(new Adapter1());

        laptop2.processKey();
    }

}
