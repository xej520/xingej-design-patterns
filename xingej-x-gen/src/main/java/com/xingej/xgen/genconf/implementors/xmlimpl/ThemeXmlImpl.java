package com.xingej.xgen.genconf.implementors.xmlimpl;

import java.util.HashMap;
import java.util.Map;

import com.xingej.xgen.genconf.constants.ExpressionEnum;
import com.xingej.xgen.genconf.constants.ThemeEnum;
import com.xingej.xgen.genconf.implementors.ThemeImplementer;
import com.xingej.xgen.genconf.vo.GenTypeModel;
import com.xingej.xgen.util.readxml.Context;

/**
 * 
 * @author erjun 2017年12月6日 下午9:32:41
 */
public class ThemeXmlImpl implements ThemeImplementer {

    @Override
    public Map<String, GenTypeModel> getMapGenTypes(String themeId, Map<String, String> params) {
        Map<String, GenTypeModel> map = new HashMap<>();

        String[] genTypeIds = null;
        String[] genTypeValues = null;

        for (int i = 0; i < genTypeIds.length; i++) {
            GenTypeModel gtm = new GenTypeModel();

            gtm.setGenTypeClass(genTypeValues[i]);
            gtm.setId(genTypeIds[i]);

            String[] paramIds = null;
            String[] paramValues = null;

            Map<String, String> paramMap = new HashMap<>();
            for (int j = 0; j < paramIds.length; j++) {
                paramMap.put(paramIds[i], paramValues[i]);
            }

            gtm.setMapParams(paramMap);

            map.put(gtm.getId(), gtm);

        }

        return map;
    }

    @Override
    public Map<String, String> getMapGenOutTypes(String themeId, Map<String, String> params) {
        return null;
    }

    @Override
    public Map<String, String> getMapProviders(String themeId, Map<String, String> params) {
        return null;
    }

    ////// ---------------------Context---------------------------
    private Context getContext(Map<String, String> param) {
        Context context = null;

        try {
            // 下面的形式，还是自己去拼接的
            // context = Context.getInstance(ExpressionEnum.xmlFilePre.getExpr()
            // + GenConfEnum.GenConf
            // + ExpressionEnum.dot.getExpr() + ExpressionEnum.xml);

            // 下面使用builder进行拼接
            // 也就是buildder模式
            context = Context.getInstance(param.get(ThemeEnum.Location) + ExpressionEnum.themeXmlName.getExpr());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return context;
    }

}
