package com.xingej.patterns.structuralType.bridge.example1;

/**
 * 类型：台式机
 * 
 * @author erjun 2017年11月16日 上午9:12:41
 */
public class Desktop implements Compute {

    @Override
    public void sale() {
        System.out.println("---台式销售---");
    }

}
