package com.xingej.xgen.genconf.implementors.dynamicparse;

import java.util.Map;

import com.xingej.xgen.genconf.vo.ExtendConfModel;
import com.xingej.xgen.genconf.vo.GenConfModel;

/**
 * 加入策略模式
 * 
 * 策略模式算法的接口
 * 
 * @author erjun 2017年12月18日 上午7:02:09
 */
public interface ParseStrategy {
    /**
     * 前两个参数，是动态传入的参数，最后一个参数，才是要解析的值
     * 
     * 解析动态内容，获得完整的字符串
     * 
     * @param gm
     *            包含参数值
     * @param mapEcms
     *            包含参数值
     * @param expr
     *            需要动态解析部分的字符串
     * @return 经过动态解析后的 完整的内容字符串
     */
    public String parseDynamicContent(GenConfModel gm, Map<String, ExtendConfModel> mapEcms, String expr);
}
