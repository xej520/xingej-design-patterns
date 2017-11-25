package com.xingej.xgen.genconf.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 针对的是第一类核心框架运行   需要的数据
// x-gen核心框架配置对应的数据model
public class GenConfModel {
    // 描述注册的多个用户需要生成的模块的model
    private List<NeedGenModel> needGens = new ArrayList<>();

    // 描述注册的多个外部主题的model
    private List<ThemeModel> themes = new ArrayList<>();

    // 描述通用的常量定义的集合
    private Map<String, String> mapContants = new HashMap<>();

    public List<NeedGenModel> getNeedGens() {
        return needGens;
    }

    public void setNeedGens(List<NeedGenModel> needGens) {
        this.needGens = needGens;
    }

    public List<ThemeModel> getThemes() {
        return themes;
    }

    public void setThemes(List<ThemeModel> themes) {
        this.themes = themes;
    }

    public Map<String, String> getMapContants() {
        return mapContants;
    }

    public void setMapContants(Map<String, String> mapContants) {
        this.mapContants = mapContants;
    }

}
