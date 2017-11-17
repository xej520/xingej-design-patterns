package com.xingej.patterns.structuralType.combination.leaf;

import com.xingej.patterns.structuralType.combination.AbstractFile;

/**
 * 组合模式：
 * 
 * 角色：叶子节点
 * 
 * @author erjun 2017年11月17日 下午1:47:06
 */
public class ImageFile implements AbstractFile {

    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("----图形文件:\t" + name + " 进行杀毒!");
    }

}
