package com.xingej.patterns.structuralType.proxy.staticProxy;

/**
 * 角色： 代理者
 * 
 * 说明：有些功能是自己做，有些是调用 被代理者
 * 
 * @author erjun 2017年11月15日 下午1:56:23
 */
public class ProxyStar implements Star {

    private Star star;

    public ProxyStar(Star star) {
        this.star = star;
    }

    @Override
    public void confer() {
        System.out.println("---经济人---面谈-----");
    }

    @Override
    public void signContract() {
        System.out.println("----经济人---签合同-----");
    }

    @Override
    public void bookTicket() {
        System.out.println("----经济人---订票-----");
    }

    @Override
    public void sing() {
        // 代理者，调用真正的API
        star.sing();
    }

    @Override
    public void collectMoney() {
        System.out.println("----经济人---收钱-----");
    }

}
