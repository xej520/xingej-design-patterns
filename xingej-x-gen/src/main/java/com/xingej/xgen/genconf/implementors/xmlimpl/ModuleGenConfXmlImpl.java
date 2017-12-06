package com.xingej.xgen.genconf.implementors.xmlimpl;

import java.util.List;
import java.util.Map;

import com.xingej.xgen.genconf.implementors.ModuleGenConfImplementor;
import com.xingej.xgen.genconf.vo.ExtendConfModel;
import com.xingej.xgen.genconf.vo.ModuleConfModel;

/**
 * 
 * @author erjun 2017年12月6日 下午9:32:47
 */
public class ModuleGenConfXmlImpl implements ModuleGenConfImplementor {

    @Override
    public ModuleConfModel getBaseModuleConfModel(Map<String, String> param) {
        return null;
    }

    @Override
    public Map<String, List<String>> getMapNeedGenTypes(Map<String, String> param) {
        return null;
    }

    @Override
    public Map<String, ExtendConfModel> getMapExtends(Map<String, String> param) {
        return null;
    }

}
