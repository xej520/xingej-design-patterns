package com.xingej.xgen.genconf.implementors.xmlimpl;

import java.util.HashMap;
import java.util.Map;

import com.xingej.xgen.genconf.constants.ExpressionEnum;
import com.xingej.xgen.genconf.constants.ThemeEnum;
import com.xingej.xgen.genconf.implementors.ThemeImplementer;
import com.xingej.xgen.genconf.vo.GenTypeModel;
import com.xingej.xgen.util.readxml.Context;
import com.xingej.xgen.util.readxml.Parser;
import com.xingej.xgen.util.readxml.ReadXmlExpression;

/**
 * 
 * @author erjun 2017年12月6日 下午9:32:41
 */
public class ThemeXmlImpl implements ThemeImplementer {

    @Override
    public Map<String, GenTypeModel> getMapGenTypes(String themeId, Map<String, String> param) {
        Map<String, GenTypeModel> map = new HashMap<>();

        String[] genTypeIds = parseGenTypeIds(this.getContext(param));
        String[] genTypeValues = parseGenTypeValues(this.getContext(param));

        for (int i = 0; i < genTypeIds.length; i++) {
            GenTypeModel gtm = new GenTypeModel();

            gtm.setGenTypeClass(genTypeValues[i]);
            gtm.setId(genTypeIds[i]);

            String[] paramIds = parseGenTypeParamIds(this.getContext(param), gtm.getId());
            String[] paramValues = parseGenTypeParamValues(this.getContext(param), gtm.getId());

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
        Map<String, String> map = new HashMap<>();

        String[] genOutTypeIds = parseOutTypeIds(this.getContext(params));
        String[] genOutTypeValues = parseOutTypeValues(this.getContext(params));

        for (int i = 0; i < genOutTypeIds.length; i++) {
            map.put(genOutTypeIds[i], genOutTypeValues[i]);
        }

        return map;
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

    //////////////////////////////////////////////////////////////
    private String[] parseGenTypeIds(Context context) {
        context.init();
        ReadXmlExpression re = Parser.parse(new ThemeBuilder().addTheme().addSeparator().addGenTypes().addSeparator()
                .addGenType().addDollar().addDot().addId().addDollar().build());

        return re.interpret(context);
    }

    // GenTypeValues 其实，对应的值是class类型
    private String[] parseGenTypeValues(Context context) {
        context.init();
        ReadXmlExpression re = Parser.parse(new ThemeBuilder().addTheme().addSeparator().addGenTypes().addSeparator()
                .addGenType().addDollar().addDot().addType().addDollar().build());

        return re.interpret(context);
    }

    private String[] parseGenTypeParamIds(Context context, String genTypeId) {
        context.init();
        ReadXmlExpression re = Parser.parse(new ThemeBuilder().addTheme().addSeparator().addGenTypes().addSeparator()
                .addGenType().addDollar().addOpenBracket().addId().addEqual().addOtherValue(genTypeId).addCloseBracket()
                .addSeparator().addParams().addSeparator().addParam().addDollar().addDot().addId().addDollar().build());

        return re.interpret(context);
    }

    private String[] parseGenTypeParamValues(Context context, String genTypeId) {
        context.init();
        ReadXmlExpression re = Parser.parse(new ThemeBuilder().addTheme().addSeparator().addGenTypes().addSeparator()
                .addGenType().addDollar().addOpenBracket().addId().addEqual().addOtherValue(genTypeId).addCloseBracket()
                .addSeparator().addParams().addSeparator().addParam().addDollar().build());

        return re.interpret(context);
    }

    ////// ---------------------getMapGenOutTypes---------------------------
    private String[] parseOutTypeIds(Context context) {
        context.init();
        ReadXmlExpression re = Parser.parse(new ThemeBuilder().addTheme().addSeparator().addGenOutTypes().addSeparator()
                .addGenOutType().addDollar().addDot().addId().addDollar().build());

        return re.interpret(context);
    }

    private String[] parseOutTypeValues(Context context) {
        context.init();
        ReadXmlExpression re = Parser.parse(new ThemeBuilder().addTheme().addSeparator().addGenOutTypes().addSeparator()
                .addGenOutType().addDollar().addDot().addType().addDollar().build());

        return re.interpret(context);
    }

}
