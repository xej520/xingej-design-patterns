package com.xingej.patterns.structuralType.bridge.example2;

import org.junit.Test;

import com.xingej.patterns.structuralType.bridge.example2.brand.Apple;
import com.xingej.patterns.structuralType.bridge.example2.brand.Brand;
import com.xingej.patterns.structuralType.bridge.example2.compute.Compute;
import com.xingej.patterns.structuralType.bridge.example2.compute.Disktop;
import com.xingej.patterns.structuralType.bridge.example2.compute.Laptop;

/**
 * 
 * 桥接模式
 * 
 * @author erjun 2017年11月16日 下午5:49:15
 */
public class BridgeTest {

    @Test
    public void test() {
        Brand brand = new Apple();

        Compute appleDisktop = new Disktop(brand);

        appleDisktop.sale();

    }

    @Test
    public void test2() {
        Brand brand = new Apple();

        Compute appleLaptop = new Laptop(brand);

        appleLaptop.sale();

    }

}
