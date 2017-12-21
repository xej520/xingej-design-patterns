package com.xingej.csdn.createtype.factory.factoryMethodPatten;

/**
 * 具体产品
 * 
 * @author erjun 2017年12月21日 上午10:21:46
 */
public class FileLogger implements Logger {

    @Override
    public void show() {
        System.out.println("-----文件日志记录器-----");
    }

}
