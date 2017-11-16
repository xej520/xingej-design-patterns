package com.xingej.patterns.structuralType.bridge.example1;

/**
 * 神州牌的PAD
 * 
 * @author erjun 2017年11月16日 上午9:18:43
 */
public class ShenzhouPad extends Pad {
    @Override
    public void sale() {
        super.sale();
        System.out.println("----<神州牌的PAD>-----");
    }
}
