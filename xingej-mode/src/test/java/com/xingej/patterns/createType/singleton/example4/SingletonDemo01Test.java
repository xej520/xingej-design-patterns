package com.xingej.patterns.singleton.example4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class SingletonDemo01Test {

    // 通过反序列化的方式 来破解 单例模式
    @Test
    public void testSingletonByFanXuliehua() throws Exception {
        StaticInnerClass2 instance = StaticInnerClass2.getInstance();
        System.out.println(instance);

        // 先序列化到硬盘上
        FileOutputStream fos = new FileOutputStream("d:/a.txt");

        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(instance);

        oos.close();

        fos.close();

        // 然后，再反序列化回来
        FileInputStream fis = new FileInputStream("d:/a.txt");

        ObjectInputStream ois = new ObjectInputStream(fis);

        StaticInnerClass2 singletonDemo02 = (StaticInnerClass2) ois.readObject();

        System.out.println(singletonDemo02);

    }

}
