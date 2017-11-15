package com.xingej.patterns.createType.singleton.example6;

import org.junit.Test;

import com.xingej.patterns.creationType.singleton.example6.SingleMode;

public class SingleModeTest {

    // 通过单例方式，来读取配置文件
    @Test
    public void testReadConfigBySingleMothod() {
        SingleMode instance = SingleMode.getInstance();

        String name = instance.getProperties("name");

        System.out.println("---name:\t" + name);
    }

}
