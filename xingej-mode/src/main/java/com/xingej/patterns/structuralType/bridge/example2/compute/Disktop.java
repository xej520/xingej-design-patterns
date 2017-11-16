package com.xingej.patterns.structuralType.bridge.example2.compute;

import com.xingej.patterns.structuralType.bridge.example2.brand.Brand;

/**
 * 类型：台式机
 * 
 * @author erjun 2017年11月16日 下午5:46:24
 */
public class Disktop extends Compute {

    public Disktop(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("的台式机>----");
    }

}
