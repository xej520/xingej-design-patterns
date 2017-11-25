package com.xingej.xgen.genconf;

import java.util.Map;

import com.xingej.xgen.genconf.vo.GenConfModel;
import com.xingej.xgen.genconf.vo.ModuleConfModel;

//业务实现对象
public class GenConfEbo implements GenConfEbi {

    // 获取数据的
    @Override
    public GenConfModel getGenConf() {
        // 获取相应的配置数据
        return null;
    }

    @Override
    public Map<String, ModuleConfModel> getMapModuleConf() {

        // 获取相应的配置数据
        return null;
    }

    // 缓存数据的
    private GenConfModel gcm = null;

    // ------------------下面是---单例模式---代码------
    private GenConfEbo() {

    }

    private static GenConfEbo instance = new GenConfEbo();

    // 提供全局的访问方式
    public static GenConfEbo getInstance() {
        return instance;
    }

}
