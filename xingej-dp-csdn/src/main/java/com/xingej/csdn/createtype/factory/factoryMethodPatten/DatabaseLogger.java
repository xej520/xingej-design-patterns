package com.xingej.csdn.createtype.factory.factoryMethodPatten;

/**
 * 具体产品
 * 
 * @author erjun 2017年12月21日 上午10:20:58
 */
public class DatabaseLogger implements Logger {

    @Override
    public void show() {
        System.out.println("----我是数据库日志记录器-----");
    }

}
