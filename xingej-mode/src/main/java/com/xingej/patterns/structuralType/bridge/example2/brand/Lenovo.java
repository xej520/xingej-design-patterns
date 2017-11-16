package com.xingej.patterns.structuralType.bridge.example2.brand;

public class Lenovo implements Brand {

    @Override
    public void sale() {
        System.out.println("---<联想品牌>---");
    }

}
