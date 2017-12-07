package com.xingej.xgen.genconf.implementors.xmlimpl;

import com.xingej.xgen.genconf.constants.ModuleGenConfEnum;

public class ModuleGenConfBuilder extends CommonBuilder<ModuleGenConfBuilder> {

    // 用来记录分步骤，拼接的字符串，也就是最终的产品
    private StringBuffer buffer = new StringBuffer();

    public ModuleGenConfBuilder addModuleGenConf() {
        buffer.append(ModuleGenConfEnum.ModuleGenConf);

        return this;
    }

    public ModuleGenConfBuilder addNeedGenTypes() {
        buffer.append(ModuleGenConfEnum.NeedGenTypes);

        return this;
    }

    public ModuleGenConfBuilder addNeedGenType() {
        buffer.append(ModuleGenConfEnum.NeedGenType);

        return this;
    }

    public ModuleGenConfBuilder addExtendConfs() {
        buffer.append(ModuleGenConfEnum.ExtendConfs);

        return this;
    }

    public ModuleGenConfBuilder addExtendConf() {
        buffer.append(ModuleGenConfEnum.ExtendConf);

        return this;
    }

    public ModuleGenConfBuilder addId() {
        buffer.append(ModuleGenConfEnum.id);

        return this;
    }

    public ModuleGenConfBuilder addIsSingle() {
        buffer.append(ModuleGenConfEnum.isSingle);

        return this;
    }

    public ModuleGenConfBuilder addNeedGenOutType() {
        buffer.append(ModuleGenConfEnum.NeedGenOutType);

        return this;
    }

    @Override
    protected StringBuffer getBuilderBuffer() {

        return this.buffer;
    }

    @Override
    protected ModuleGenConfBuilder getBuilderClassInstance() {

        // 调用自己
        return this;
    }

}
