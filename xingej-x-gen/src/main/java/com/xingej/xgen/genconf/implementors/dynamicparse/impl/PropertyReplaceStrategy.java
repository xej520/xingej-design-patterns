package com.xingej.xgen.genconf.implementors.dynamicparse.impl;

import java.util.Map;

import com.xingej.xgen.genconf.implementors.dynamicparse.ParseStrategy;
import com.xingej.xgen.genconf.vo.ExtendConfModel;
import com.xingej.xgen.genconf.vo.GenConfModel;

/**
 * 直接引用本模块配置的其他ExtendConf的数据，有两种方式，第一种属性替换
 * 
 * 属性替换策略
 * 
 * @author erjun 2017年12月18日 上午7:11:41
 */
public class PropertyReplaceStrategy implements ParseStrategy {

    @Override
    public String parseDynamicContent(GenConfModel gm, Map<String, ExtendConfModel> mapEcms, String expr) {
        String retStr = "";

        ExtendConfModel ecm = mapEcms.get(expr);

        if (ecm != null) {
            retStr = ecm.getValue();
        }

        return retStr;
    }

}
