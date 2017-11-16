package com.xingej.patterns.structuralType.bridge.example1;

/**
 * 类型：PAD
 * 
 * @author erjun 2017年11月16日 上午9:12:08
 */
public class Pad implements Compute {

    @Override
    public void sale() {
        System.out.println("---Pad销售---");
    }

}
