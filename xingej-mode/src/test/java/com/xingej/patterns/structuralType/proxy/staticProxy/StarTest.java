package com.xingej.patterns.structuralType.proxy.staticProxy;

import org.junit.Test;

/**
 * 代理者：静态代理者测试
 * 
 * 总结:静态代理方式，代理者需要自己创建
 * 
 * @author erjun 2017年11月15日 下午1:57:30
 */
public class StarTest {

    @Test
    public void test() {
        // 创建 真正的歌星(被代理者)
        Star star = new RealStar();

        // 代理者
        Star proxy = new ProxyStar(star);

        proxy.confer();
        proxy.signContract();
        proxy.bookTicket();

        proxy.sing();

        proxy.collectMoney();

    }

}
