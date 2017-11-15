package com.xingej.patterns.createType.prototype.example2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import org.junit.Test;

import com.xingej.patterns.creationType.prototype.example2.Cat;

/**
 * 测试，使用序列化和反序列化的方式来实现 深复制，或者说 深克隆
 * 
 * @author erjun 2017年11月14日 上午8:57:24
 */
public class CatTest {

    @Test
    public void testByXuliehua() throws Exception {
        // 先创建一个原对象
        Cat cat = new Cat();
        cat.setName("咩咩羊");
        Date birthday = new Date();
        cat.setBirthday(birthday);

        System.out.println("---原对象1--->:\t" + cat.toString());

        // 通过序列化 和 反序列方式
        // 1、先将cat进行序列化
        // 其实，这里，也可以使用FileOutputStream, 将对象存储到文件里
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(cat);
        // 将流转换成 字节数组，
        // 其实，最终将一个对象，通过流的方式 转换了字节数组
        byte[] catArray = baos.toByteArray();

        // 2、再进行反序列化
        ByteArrayInputStream bais = new ByteArrayInputStream(catArray);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Cat newCat = (Cat) ois.readObject();

        // 克隆完成后，进行测试，
        // 修改cat中birthday的值，观察newCat是否变化了，
        // 如果没有变化，就说明是深复制了
        birthday.setTime(2343243243421L);

        System.out.println("---原对象2--->:\t" + cat.toString());
        System.out.println("---clone的对象--->:\t" + newCat.toString());

        // 经观察，clone的对象的birthday没有发生改变
    }

}
