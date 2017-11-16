package com.xingej.patterns.structuralType.bridge.example2.brand;

/**
 * 桥接模式
 * 
 * 总结：
 * 
 * 将多层继承模式，改成 桥接模式；
 * 
 * 桥接模式：有两个维度在变化，并且 需要进行组合时，可以使用桥接模式
 * 
 * 以前是两个维度是继承，现在改成各自独立变化；
 * 
 * 桥接，就是在一个维度中，引用另一个维度的接口，这样，就可以两个维度链接在一起。
 * 
 * 如：这里分成了品牌Brand 一个维度，类型Compute为一个维度
 * 
 * <<可扩展性>>： 直接添加子类就可以了。不用修改源代码的;比方说，新增一个IPAD，直接继承compute就可以了
 * 
 * @author erjun 2017年11月16日 下午5:39:03
 */
public interface Brand {
    void sale();
}
