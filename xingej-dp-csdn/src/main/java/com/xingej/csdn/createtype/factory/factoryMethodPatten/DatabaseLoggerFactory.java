package com.xingej.csdn.createtype.factory.factoryMethodPatten;

/**
 * 具体工厂：数据库工厂
 * 
 * @author erjun 2017年12月21日 上午10:23:55
 */
public class DatabaseLoggerFactory implements LoggerFactory {

    @Override
    public Logger getInstance() {
        return new DatabaseLogger();
    }

}
