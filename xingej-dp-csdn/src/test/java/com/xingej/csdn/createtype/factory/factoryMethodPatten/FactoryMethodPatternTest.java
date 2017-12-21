package com.xingej.csdn.createtype.factory.factoryMethodPatten;

import org.junit.Test;

import com.xingej.csdn.utils.XMLUtils;

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

    // -----反射+XML方式，进行扩展
    // 其实，不一定是XML文件，也可用是普通的properties文件
    // 只是，要写专门的解析器去解释配置文件而已
    @Test
    public void test3() {
        // 1、获取配置文件中的工厂名称
        String factoryClassName = XMLUtils.getClazz();

        // 2、通过反射来创建工厂实例
        LoggerFactory loggerFactory = null;

        try {
            Class clazz = Class.forName("com.xingej.csdn.createtype.factory.factoryMethodPatten." + factoryClassName);

            loggerFactory = (LoggerFactory) clazz.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 3、通过工厂实例，来创建日志对象
        Logger logger = loggerFactory.getInstance();

        logger.show();
    }

}
