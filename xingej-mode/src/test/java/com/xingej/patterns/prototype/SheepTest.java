package com.xingej.patterns.prototype;

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

    @Test
    public void testDeepReplication() throws CloneNotSupportedException {
        Sheep2 sheep = new Sheep2();

        Date birthday = new Date();
        sheep.setName("多利");

        sheep.setBirthday(birthday);

        // 开始 深复制
        Sheep2 sheep2 = (Sheep2) sheep.clone();

        System.out.println("---sheep1----:\t" + sheep);
        System.out.println("---sheep1---name--" + sheep.getName());
        System.out.println("---sheep1---birthday--" + sheep.getBirthday());

        // 修改原对象的时间，
        // 1、查看，原对象的时间，是否变化了
        // 2、克隆对象的时间，是否变化了，是否是最新的时间
        birthday.setTime(234324324342L);

        System.out.println("---sheep1---birthday--" + sheep.getBirthday());

        sheep2.setName("猫");
        System.out.println("---sheep2----:\t" + sheep2);
        System.out.println("---sheep2---name---:\t" + sheep2.getName());

        // 观察时间，是否与 原对象的旧时间 是否一样，
        // 一样的话，说明，是深复制，
        System.out.println("---sheep2---birthday--:\t" + sheep2.getBirthday());

        // 总结
        // 修改了原对象的时间 后
        // 1、拷贝对象的时间，并没有发生变化，还是旧的对象时间
        // 2、原对象的时间，发生了变化
    }

}
