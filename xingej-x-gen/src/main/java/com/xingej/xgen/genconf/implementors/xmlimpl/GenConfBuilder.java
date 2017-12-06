package com.xingej.xgen.genconf.implementors.xmlimpl;

import com.xingej.xgen.genconf.constants.GenConfEnum;

/**
 * 构造器builder
 * 
 * @author erjun 2017年12月7日 上午7:08:02
 */
public class GenConfBuilder extends CommonBuilder<GenConfBuilder> {
    // 用来记录分步骤，拼接的字符串，也就是最终的产品
    private StringBuffer buffer = new StringBuffer();

    // 增加节点GenConf,也叫元素
    // 支持连缀，
    public GenConfBuilder addGenConf() {
        buffer.append(GenConfEnum.GenConf);
        return this;
    }

    // 增加节点NeedGens
    // 支持连缀，
    public GenConfBuilder addNeedGens() {
        buffer.append(GenConfEnum.NeedGens);
        return this;
    }

    // 增加节点NeedGen
    // 支持连缀，
    public GenConfBuilder addNeedGen() {
        buffer.append(GenConfEnum.NeedGen);
        return this;
    }

    // 增加节点Themes
    // 支持连缀，
    public GenConfBuilder addThemes() {
        buffer.append(GenConfEnum.Themes);
        return this;
    }

    // 增加节点Theme
    // 支持连缀，
    public GenConfBuilder addTheme() {
        buffer.append(GenConfEnum.Theme);
        return this;
    }

    // 增加节点Constants
    // 支持连缀，
    public GenConfBuilder addConstants() {
        buffer.append(GenConfEnum.Constants);
        return this;
    }

    // 增加节点Constant
    // 支持连缀，
    public GenConfBuilder addConstant() {
        buffer.append(GenConfEnum.Constant);
        return this;
    }

    // 增加节点Provider
    // 支持连缀，
    public GenConfBuilder addProvider() {
        buffer.append(GenConfEnum.provider);
        return this;
    }

    // 增加节点ThemeId
    // 支持连缀，
    public GenConfBuilder addThemeId() {
        buffer.append(GenConfEnum.themeId);
        return this;
    }

    // 增加节点Params
    // 支持连缀，
    public GenConfBuilder addParams() {
        buffer.append(GenConfEnum.Params);
        return this;
    }

    // 增加节点Param
    // 支持连缀，
    public GenConfBuilder addParam() {
        buffer.append(GenConfEnum.Param);
        return this;
    }

    @Override
    protected StringBuffer getBuilderBuffer() {

        return this.buffer;
    }

    @Override
    protected GenConfBuilder getBuilderClassInstance() {

        // 调用自己
        return this;
    }

}
