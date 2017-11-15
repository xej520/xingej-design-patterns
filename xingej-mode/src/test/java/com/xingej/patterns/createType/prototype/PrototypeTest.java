package com.xingej.patterns.prototype;

import org.junit.Test;

/**
 * 原型模式测试：到底使用原型模式 比 使用 new方式的效率提高如何
 * 
 * -------------浅复制测试--------------
 * 
 * @author erjun 2017年11月14日 上午9:15:15
 */
public class PrototypeTest {

    @Test
    public void test() throws CloneNotSupportedException {
        int size = 1000;

        testByNew(size);

        testByClone(size);

        // 测试结果：
        // ----通过new的方式---耗时-----: 10309
        // ----通过clone的方式---耗时-----: 11

        // 可见，使用克隆的方式，效率提高了1000倍
    }

    // 通过new的方式来创建对象，
    // 查看 用时多少
    private void testByNew(int size) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            new Dog();
        }

        long end = System.currentTimeMillis();
        System.out.println("----通过new的方式---耗时-----:\t" + (end - start));
    }

    // 通过clone的方式来创建对象，
    // 查看 用时多少
    private void testByClone(int size) throws CloneNotSupportedException {
        long start = System.currentTimeMillis();
        // 1、先创建一个原对象，
        Dog dog = new Dog();

        for (int i = 0; i < size; i++) {
            // 2、再通过克隆的方式，来创建对象
            Dog dog2 = (Dog) dog.clone();
        }

        long end = System.currentTimeMillis();
        System.out.println("----通过clone的方式---耗时-----:\t" + (end - start));
    }

    class Dog implements Cloneable {

        public Dog() {
            // 这里模拟一下场景：
            // 创建一个对象，比较耗时
            try {
                Thread.sleep(10);// 耗时10毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

}
