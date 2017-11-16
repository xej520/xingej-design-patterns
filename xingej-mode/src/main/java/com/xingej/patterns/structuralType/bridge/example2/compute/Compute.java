package com.xingej.patterns.structuralType.bridge.example2.compute;

import com.xingej.patterns.structuralType.bridge.example2.brand.Brand;

/**
 * 桥接模式
 * 
 * @author erjun 2017年11月16日 下午5:43:23
 */
public abstract class Compute {
    private Brand brand;

    public Compute(Brand brand) {
        this.brand = brand;
    }

    public void sale() {
        brand.sale();
    }
}
