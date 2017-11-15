package com.xingej.patterns.creationType.singleton.example6;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SingleMode {

    private SingleMode() {
        // 创建对象时，会默认加载配置文件
        readConfig();
    }

    private static class InnerSingle {
        private static SingleMode instance = new SingleMode();
    }

    public static SingleMode getInstance() {
        return InnerSingle.instance;
    }

    // ---------------------上面是单例模式----------------------------
    private Properties properties;

    private InputStream inputStream = null;

    private void readConfig() {
        properties = new Properties();

        try {
            // 注意，配置文件的路径
            inputStream = SingleMode.class.getResourceAsStream("/single.properties");

            properties.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 提供对外的接口，
    // 查询配置文件的属性信息
    public String getProperties(String key) {
        return properties.getProperty(key);
    }
}
