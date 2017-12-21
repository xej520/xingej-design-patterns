package com.xingej.csdn.createtype.factory.factoryMethodPatten;

/**
 * 文件日志工厂
 * 
 * @author erjun 2017年12月21日 上午10:24:56
 */
public class FileLoggerFactory implements LoggerFactory {

    @Override
    public Logger getInstance() {
        return new FileLogger();
    }

}
