package com.xingej.csdn.createtype.factory.factoryMethodPatten;

import org.junit.Test;

/**
 * 
 * @author erjun 2017年12月21日 上午10:25:58
 */
public class FactoryMethodPatternTest {

    @Test
    public void test() {
        Logger logger = new FileLoggerFactory().getInstance();

        System.out.println("----logger-----:\t");

        logger.show();
    }

    @Test
    public void test2() {
        Logger logger = new DatabaseLoggerFactory().getInstance();

        System.out.println("----logger-----:\t");

        logger.show();
    }

}
