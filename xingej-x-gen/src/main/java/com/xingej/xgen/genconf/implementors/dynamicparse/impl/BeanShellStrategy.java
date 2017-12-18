package com.xingej.xgen.genconf.implementors.dynamicparse.impl;

import java.util.Map;

import com.xingej.xgen.genconf.implementors.dynamicparse.ParseStrategy;
import com.xingej.xgen.genconf.vo.ExtendConfModel;
import com.xingej.xgen.genconf.vo.GenConfModel;

import bsh.Interpreter;

/**
 * 直接引用本模块配置的其他ExtendConf的数据，有两种方式，第2种，使用beanshell脚本方式
 * 
 * @author erjun 2017年12月18日 上午7:13:55
 */
public class BeanShellStrategy implements ParseStrategy {

    @Override
    public String parseDynamicContent(GenConfModel gm, Map<String, ExtendConfModel> mapEcms, String expr) {
        Interpreter interpreter = new Interpreter();

        String retStr = "";
        try {
            // 设置要传入的参数
            interpreter.set("gm", gm);
            interpreter.set("mapEcms", mapEcms);

            // 执行
            interpreter.eval("retValue=" + expr);

            // 获取返回值
            retStr = interpreter.get("retValue").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retStr;

    }

}
