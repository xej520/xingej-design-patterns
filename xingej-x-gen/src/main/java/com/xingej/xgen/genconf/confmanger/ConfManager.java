package com.xingej.xgen.genconf.confmanger;

import java.util.HashMap;
import java.util.Map;

import com.xingej.xgen.genconf.implementors.GenConfImplementor;
import com.xingej.xgen.genconf.implementors.ModuleGenConfImplementor;
import com.xingej.xgen.genconf.vo.GenConfModel;
import com.xingej.xgen.genconf.vo.ModuleConfModel;
import com.xingej.xgen.genconf.vo.NeedGenModel;

// 真正的获取配置数据，并缓存配置数据
// 同样适用单例模式
public class ConfManager {
    // 下面是单例模式-----懒汉式-----
    private ConfManager(GenConfImplementor provider) {
        readConf(provider);
    }

    private static ConfManager instance = null;

    public static ConfManager getInstance(GenConfImplementor provider) {
        if (null == instance) {
            instance = new ConfManager(provider);
        }

        return instance;
    }

    // -------------------------------------
    // 存储 需要 缓存的数据
    private GenConfModel getConf = new GenConfModel();

    private Map<String, ModuleConfModel> mapModuleConf = new HashMap<>();

    // GenConfImplementor
    // 由于使用桥接模式，本来在这个类，应该持有 实现的引用的，
    // 但是，由于这个类是单例模式，就没必要持有了
    // 改成，用参数的方式，传进来即可了。
    private void readConf(GenConfImplementor provider) {
        // 这里是真正的获取配置数据
        readGenConf(provider);

        for (NeedGenModel ngm : provider.getNeedGens()) {
            readOneModuleGenConf(ngm);
        }
    }

    // -------------------------------------

    public GenConfModel getGetConf() {
        return getConf;
    }

    public Map<String, ModuleConfModel> getMapModuleConf() {
        return mapModuleConf;
    }

    // -------------------------------------
    private void readGenConf(GenConfImplementor provider) {
        // 然后把获取到的配置数据 设置到属性上，缓存下来
        getConf.setNeedGens(provider.getNeedGens());
        getConf.setThemes(provider.getThemeo());
        getConf.setMapContants(provider.getMapConstants());

    }

    private void readOneModuleGenConf(NeedGenModel ngm) {
        ModuleConfModel mcm = new ModuleConfModel();

        // 全路径类名
        String providerClassName = this.getConf.getThemeById(ngm.getTheme()).getMapProviders().get(ngm.getProvider());
        ModuleGenConfImplementor userGenConfImpl = null;
        try {
            userGenConfImpl = (ModuleGenConfImplementor) Class.forName(providerClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mcm = userGenConfImpl.getBaseModuleConfModel(ngm.getMapParams());
        mcm.setUseTheme(ngm.getTheme());

        mcm.setMapExtends(userGenConfImpl.getMapExtends(ngm.getMapParams()));
        mcm.setMapNeedGenTypes(userGenConfImpl.getMapNeedGenTypes(ngm.getMapParams()));

        // 设置到缓存里
        this.mapModuleConf.put(mcm.getModuleId(), mcm);
    }

}
