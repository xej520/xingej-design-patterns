package com.xingej.patterns.structuralType.bridge.example2.compute;

import com.xingej.patterns.structuralType.bridge.example2.brand.Brand;

public class Laptop extends Compute {

    public Laptop(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("笔记本>----");
    }

}
