package com.xingej.patterns.structuralType.combination.leaf;

import com.xingej.patterns.structuralType.combination.AbstractFile;

/**
 * 组合模式：
 * 
 * 角色：叶子节点
 * 
 * @author erjun 2017年11月17日 下午1:47:54
 */
public class TextFile implements AbstractFile {
    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("----文本文件:\t" + name + " 进行杀毒!");
    }

}
