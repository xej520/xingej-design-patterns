package com.xingej.patterns.structuralType.bridge.example1;

/**
 * 品牌：联想
 * 
 * 组合在一起，就是 联想牌的台式机
 * 
 * ----------------->总结<----------
 * 
 * 其实，这种多层继承关系，扩展性很麻烦的
 *
 * 因为，这里是由两个因素来确定一个产品的，如 台式机 + 品牌 才能确定一个
 * 
 * 联想+台式机，联想+笔记本，神州+PAD 违反了
 * 
 * 单一职责原则;
 * 
 * 应该采用组合的方式
 * 
 * @author erjun 2017年11月16日 上午9:15:13
 */
public class LenovoDesktop extends Desktop {
    @Override
    public void sale() {
        super.sale();
        System.out.println("---->联想牌的台式机<----");
    }
}
