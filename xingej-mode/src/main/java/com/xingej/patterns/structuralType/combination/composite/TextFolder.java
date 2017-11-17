package com.xingej.patterns.structuralType.combination.composite;

import java.util.ArrayList;
import java.util.List;

import com.xingej.patterns.structuralType.combination.AbstractFile;

/**
 * 组合设计模式
 * 
 * 角色：容器
 * 
 * @author erjun 2017年11月17日 下午1:55:21
 */
public class TextFolder implements AbstractFile {
    private String name;

    private List<AbstractFile> leafList = new ArrayList<>();

    public TextFolder(String name) {
        this.name = name;
    }

    // 使用统一的一个API，来处理叶子节点和容器节点的；也就是处理 局部和整体是一样的
    @Override
    public void killVirus() {
        System.out.println("----文本文件夹:\t" + name + " 进行杀毒!");

        // 这里存在一个潜在的递归调用
        // 如果file的类型是 Folder的话，就会递归
        for (AbstractFile file : leafList) {
            file.killVirus();
        }
    }

    public void add(AbstractFile file) {
        leafList.add(file);
    }

    public void remove(AbstractFile file) {
        leafList.remove(file);
    }

    public AbstractFile get(int index) {
        return leafList.get(index);
    }

}
