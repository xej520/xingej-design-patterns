package com.xingej.xgen.genconf.implementors;

import java.util.List;
import java.util.Map;

import com.xingej.xgen.genconf.vo.NeedGenModel;
import com.xingej.xgen.genconf.vo.ThemeModel;

/**
 * 获取核心框架配置数据的接口 【第一类数据】
 * 
 * @author erjun 2017年11月26日 上午6:06:05
 */
public interface GenConfImplementor {

    // 获取核心框架配置中心注册的需要生成的模块的配置数据
    public List<NeedGenModel> getNeedGens();

    // 获取核心框架配置中心的外部主题的配置数据
    public List<ThemeModel> getThemeo();

    // 获取核心框架配置中注册的定义的公共常量
    public Map<String, String> getMapConstants();

}
