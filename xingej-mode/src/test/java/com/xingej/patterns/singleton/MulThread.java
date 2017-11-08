package com.xingej.patterns.singleton;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;

import com.xingej.patterns.singleton.example1.HungryMethod;
import com.xingej.patterns.singleton.example2.LazyMethod;
import com.xingej.patterns.singleton.example3.DoubleCheck;
import com.xingej.patterns.singleton.example4.StaticInnerClass;
import com.xingej.patterns.singleton.example5.EnumMethod;

/**
 * 多线程方式来测试5种单例模式的效率
 * 
 * @author erjun 2017年11月8日 下午4:07:14
 */
public class MulThread {
    private static final int threadNum = 10;

    private static final int count = 10 * 10000; // 调用单例 对象 10万次

    private static CountDownLatch countDownLatch = new CountDownLatch(threadNum);

    // 饿汉式 效率测试
    @Test
    public void testEHanShi() throws Exception {

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < threadNum; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    for (int j = 0; j < count; j++) {
                        HungryMethod.getInstance();
                    }

                    countDownLatch.countDown();
                }
            }).start();
        }

        // 其实，所有的这些阻塞，内部其实都有一个死循环去监控的
        countDownLatch.await();

        long endTime = System.currentTimeMillis();
        System.out.println("----饿汉式---执行时间---:\t" + (endTime - startTime) + " 毫秒");

    }

    // 懒汉式 效率测试
    @Test
    public void testLanHanShi() throws Exception {

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < threadNum; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    for (int j = 0; j < count; j++) {
                        LazyMethod.getInstacne();
                    }

                    countDownLatch.countDown();
                }
            }).start();
        }

        // 其实，所有的这些阻塞，内部其实都有一个死循环去监控的
        countDownLatch.await();

        long endTime = System.currentTimeMillis();
        System.out.println("----懒汉式---执行时间---:\t" + (endTime - startTime) + " 毫秒");

    }

    // 双重检测 效率测试
    @Test
    public void test2Check() throws Exception {

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < threadNum; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    for (int j = 0; j < count; j++) {
                        DoubleCheck.getInstance();
                    }

                    countDownLatch.countDown();
                }
            }).start();
        }

        // 其实，所有的这些阻塞，内部其实都有一个死循环去监控的
        countDownLatch.await();

        long endTime = System.currentTimeMillis();
        System.out.println("----双重检测---执行时间---:\t" + (endTime - startTime) + " 毫秒");

    }

    // 静态内部类 单例模式 效率测试
    @Test
    public void testStaticInnerClass() throws Exception {

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < threadNum; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    for (int j = 0; j < count; j++) {
                        StaticInnerClass.getInstance();
                    }

                    countDownLatch.countDown();
                }
            }).start();
        }

        // 其实，所有的这些阻塞，内部其实都有一个死循环去监控的
        countDownLatch.await();

        long endTime = System.currentTimeMillis();
        System.out.println("----静态内部类方式---执行时间---:\t" + (endTime - startTime) + " 毫秒");

    }

    // 枚举类方式的单例模式 效率测试
    @Test
    public void testEnumMethod() throws Exception {

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < threadNum; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    for (int j = 0; j < count; j++) {
                        // -------------------------------注意-------------------------------
                        // ----枚举类，必须有接收值，就是等式左边这些Object object， 不然有问题哦
                        Object object = EnumMethod.INSTANCE;
                    }

                    countDownLatch.countDown();
                }
            }).start();
        }

        // 其实，所有的这些阻塞，内部其实都有一个死循环去监控的
        countDownLatch.await();

        long endTime = System.currentTimeMillis();
        System.out.println("----枚举类方式---执行时间---:\t" + (endTime - startTime) + " 毫秒");

    }

}
