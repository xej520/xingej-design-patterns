package com.xingej.xgen.genconf;

import com.xingej.xgen.genconf.implementors.GenConfImplementor;

/**
 * 简单工厂的本质是： 选择实现
 * 
 * @author erjun 2017年11月25日 下午9:27:35
 */
public class GenConfFactory {

    // 禁止 外界创建此对象
    private GenConfFactory() {
    }

    // 存在的问题？
    // 如果此对象，被创建多次的话，那么就会重复获取配置数据，浪费程序运行时间，
    // 以及浪费内存空间
    public static GenConfEbi createGenConfEbi(GenConfImplementor provider) {

        // 改成单例模式方式获取
        return GenConfEbo.getInstance(provider);
    }
}
