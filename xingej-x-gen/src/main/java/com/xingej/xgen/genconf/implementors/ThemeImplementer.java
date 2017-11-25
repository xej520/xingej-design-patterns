package com.xingej.xgen.genconf.implementors;

import java.util.Map;

import com.xingej.xgen.genconf.vo.GenTypeModel;

/**
 * 针对 第三类数据， 外部主题的配置数据
 * 
 * @author erjun 2017年11月26日 上午6:31:55
 */
public interface ThemeImplementer {

    /**
     * 根据themeId 和 在核心框架里面注册 theme 时配置的相应的参数，来获取theme 中定义的能生成的功能类型
     * 
     * @param themeId
     *            themeId 如simple
     * @param params
     *            核心框架里面注册 theme 时配置的相应的参数
     * @return 获取theme 中定义的能生成的功能类型
     */
    public Map<String, GenTypeModel> getMapGenTypes(String themeId, Map<String, String> params);

    public Map<String, String> getMapGenOutTypes(String themeId, Map<String, String> params);

    public Map<String, String> getMapProviders(String themeId, Map<String, String> params);
}
