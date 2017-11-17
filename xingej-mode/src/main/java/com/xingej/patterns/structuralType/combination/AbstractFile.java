package com.xingej.patterns.structuralType.combination;

/**
 * 组合模式：
 * 
 * 总结：
 * 
 * 1、只要是树形结构，就可以使用 组合模式
 * 
 * 2、对叶子节点和容器 进行统一的处理，一个API就可以了；如叶子节点调用的killVirus,容器节点调用的killVirus
 * 
 * ------->如何使用组合模式?<-------------
 * 
 * 1、叶子节点和容器节点 都是实现了相同的接口AbstractFile；实现相同的API
 * 
 * 2、在容器节点里，添加一个集合List<AbstractFile> 专门用来存储叶子节点的，并且为此集合
 * 
 * 添加了一些操作，如add,remove,get等操作
 * 
 * 上面这一步特别重要，一定要添加集合；好多框架里，都用到这种形式了
 * 
 * @author erjun 2017年11月17日 下午1:41:43
 */
public interface AbstractFile {
    void killVirus();
}
