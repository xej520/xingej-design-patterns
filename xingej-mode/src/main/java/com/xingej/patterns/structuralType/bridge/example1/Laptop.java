package com.xingej.patterns.structuralType.bridge.example1;

/**
 * 类型：笔记本
 * 
 * @author erjun 2017年11月16日 上午9:12:29
 */
public class Laptop implements Compute {

    @Override
    public void sale() {
        System.out.println("---笔记本销售---");
    }

}
