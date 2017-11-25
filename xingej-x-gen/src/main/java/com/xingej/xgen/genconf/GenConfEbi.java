package com.xingej.xgen.genconf;

import java.util.Map;

import com.xingej.xgen.genconf.vo.GenConfModel;
import com.xingej.xgen.genconf.vo.ModuleConfModel;

/**
 * 配置管理模块的对外接口设计
 * 
 * Ebi：就是业务接口
 * 
 * @author erjun 2017年11月25日 下午6:15:38
 */
public interface GenConfEbi {

    /**
     * 获取x-gen核心框架 运行所需要的配置数据model
     * 
     * @return 核心框架 运行所需要的配置数据model
     */
    public GenConfModel getGenConf();

    /**
     * 获取需要生成的所有的模块的配置
     * 
     * @return 包含所有需要生成的所有模块的配置数据的Map, key:模块的ID，value:相应的模块的配置数据的model
     */
    public Map<String, ModuleConfModel> getMapModuleConf();
}
