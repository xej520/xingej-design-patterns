package com.xingej.xgen.genconf.implementors.xmlimpl;

import java.util.List;
import java.util.Map;

import com.xingej.xgen.genconf.implementors.GenConfImplementor;
import com.xingej.xgen.genconf.vo.NeedGenModel;
import com.xingej.xgen.genconf.vo.ThemeModel;

/**
 * 
 * @author erjun 2017年12月6日 下午9:32:53
 */
// 通过Parser去获取到配置的数据，然后，把这些数据组成GenConfImplementor所需要的样子
// GenConfXmlImpl 充当Parser的客户端
public class GenConfXmlImpl implements GenConfImplementor {

    @Override
    public List<NeedGenModel> getNeedGens() {
        return null;
    }

    @Override
    public List<ThemeModel> getThemeo() {
        return null;
    }

    @Override
    public Map<String, String> getMapConstants() {
        return null;
    }

}
