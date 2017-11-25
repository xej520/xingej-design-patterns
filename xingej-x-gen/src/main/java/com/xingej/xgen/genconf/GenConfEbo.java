package com.xingej.xgen.genconf;

import java.util.Map;

import com.xingej.xgen.genconf.confmanger.ConfManager;
import com.xingej.xgen.genconf.implementors.GenConfImplementor;
import com.xingej.xgen.genconf.vo.GenConfModel;
import com.xingej.xgen.genconf.vo.ModuleConfModel;

//业务实现对象
//负责完成配置管理模块的业务功能
public class GenConfEbo implements GenConfEbi {

    // 持有 获取核心框架配置数据的 具体实现接口对象
    private GenConfImplementor provider;

    // 获取数据的
    @Override
    public GenConfModel getGenConf() {
        // 获取相应的配置数据
        return ConfManager.getInstance(provider).getGetConf();
    }

    @Override
    public Map<String, ModuleConfModel> getMapModuleConf() {

        // 获取相应的配置数据
        return ConfManager.getInstance(provider).getMapModuleConf();
    }

    // 缓存数据的
    // ConfManager 类里，存储缓存，不在GenConfEbo类进行了
    // private GenConfModel gcm = null;

    // ------------------下面是---单例模式---代码------
    private GenConfEbo(GenConfImplementor provider) {
        this.provider = provider;
    }

    private static GenConfEbo instance;

    // 提供全局的访问方式
    public static GenConfEbo getInstance(GenConfImplementor provider) {
        if (null == instance) {
            instance = new GenConfEbo(provider);
        }

        return instance;
    }

}
