package com.xingej.patterns.structuralType.bridge.example1;

/**
 * 品牌：联想
 * 
 * 组合在一起，就是 联想牌的台式机
 * 
 * @author erjun 2017年11月16日 上午9:16:56
 */
public class LenovoLaptop extends Laptop {
    @Override
    public void sale() {
        super.sale();
        System.out.println("---->联想牌的笔记本<----");
    }
}
