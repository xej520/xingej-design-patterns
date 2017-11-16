package com.xingej.patterns.structuralType.bridge.example2.brand;

public class Apple implements Brand {

    @Override
    public void sale() {
        System.out.print("---<销售苹果品牌");
    }

}
