package com.xingej.patterns.structuralType.proxy.dynamicProxy;

/**
 * 角色：被代理者(歌唱家)
 * 
 * @author erjun 2017年11月15日 下午2:26:10
 */
public class RealStar implements Star {

    @Override
    public void confer() {
        System.out.println("----面谈-----");
    }

    @Override
    public void signContract() {
        System.out.println("----签合同-----");
    }

    @Override
    public void bookTicket() {
        System.out.println("----订票-----");
    }

    @Override
    public void sing() {
        System.out.println("----唱歌-----");
    }

    @Override
    public void collectMoney() {
        System.out.println("----收钱-----");
    }

}
