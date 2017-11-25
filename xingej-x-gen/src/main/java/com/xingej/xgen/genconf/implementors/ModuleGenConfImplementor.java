package com.xingej.xgen.genconf.implementors;

import java.util.List;
import java.util.Map;

import com.xingej.xgen.genconf.vo.ExtendConfModel;
import com.xingej.xgen.genconf.vo.ModuleConfModel;
//模块本身的实现

//针对的是 第2类数据  用户需要生成的模块的配置数据
public interface ModuleGenConfImplementor {
    /**
     * 根据核心框架里面 注册的需要生成模块的配置参数，来获取相应的需要生成模块的配置数据model， 数据只有基本的部分
     * 
     * @param param
     *            在核心框架里面注册的需要生成模块的配置参数
     * @return 相应的需要生成模块的配置数据model，数据只有基本的部分
     */
    public ModuleConfModel getBaseModuleConfModel(Map<String, String> param);

    /**
     * 根据核心框架里面注册的需要生成模块的配置参数，来获取需要生成模块中配置的需要生成的功能类型
     * 
     * @param param
     *            根据核心框架里面注册的需要生成模块的配置参数
     * @return
     */
    public Map<String, List<String>> getMapNeedGenTypes(Map<String, String> param);

    public Map<String, ExtendConfModel> getMapExtends(Map<String, String> param);
}
