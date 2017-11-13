package com.xingej.prototype;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

/**
 * 原型模型 测试
 * 
 * @author erjun 2017年11月13日 上午9:06:14
 */
public class SheepTest {

    @Test
    public void test() {
        fail("Not yet implemented");
    }

    // 浅复制
    // 浅复制，里面用到的对象，都是公用的，只有变化，所有的对象都会变的
    // 比方说，sheep 里用到里birthday对象，
    // sheep 与 sheep2 都用同一个birthday对象。
    @Test
    public void testShallowCopy() throws CloneNotSupportedException {
        Sheep sheep = new Sheep();

        Date birthday = new Date();
        sheep.setName("多利");

        sheep.setBirthday(birthday);

        // 开始 浅复制
        Sheep sheep2 = (Sheep) sheep.clone();

        System.out.println("---sheep----:\t" + sheep);
        System.out.println(sheep.getName());
        System.out.println(sheep.getBirthday());

        birthday.setTime(234324324342L);

        System.out.println(sheep.getBirthday());

        sheep2.setName("猫");
        System.out.println("---sheep----:\t" + sheep2);
        System.out.println(sheep2.getName());
        System.out.println(sheep2.getBirthday());

    }

}
