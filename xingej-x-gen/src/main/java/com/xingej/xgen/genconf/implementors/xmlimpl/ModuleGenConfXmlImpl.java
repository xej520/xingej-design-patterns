package com.xingej.xgen.genconf.implementors.xmlimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xingej.xgen.genconf.constants.ExpressionEnum;
import com.xingej.xgen.genconf.constants.ModuleGenConfEnum;
import com.xingej.xgen.genconf.implementors.ModuleGenConfImplementor;
import com.xingej.xgen.genconf.vo.ExtendConfModel;
import com.xingej.xgen.genconf.vo.ModuleConfModel;
import com.xingej.xgen.util.readxml.Context;
import com.xingej.xgen.util.readxml.Parser;
import com.xingej.xgen.util.readxml.ReadXmlExpression;

/**
 * 
 * @author erjun 2017年12月6日 下午9:32:47
 */
public class ModuleGenConfXmlImpl implements ModuleGenConfImplementor {

    @Override
    public ModuleConfModel getBaseModuleConfModel(Map<String, String> param) {
        ModuleConfModel mcm = new ModuleConfModel();

        // 设置模块的标识
        this.parseModuleId(mcm, this.getContext(param));

        return mcm;
    }

    @Override
    public Map<String, List<String>> getMapNeedGenTypes(Map<String, String> param) {
        return this.parseNeedGenTypes(this.getContext(param));
    }

    @Override
    public Map<String, ExtendConfModel> getMapExtends(Map<String, String> param) {
        return parseMapExtends();
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
            context = Context.getInstance(
                    new GenConfBuilder().addXmlFilePre().addOtherValue(param.get(ModuleGenConfEnum.fileName)).build());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return context;
    }

    ////// ---------------------BaseModuleConfModel---------------------------
    // 这是按引用传递，私有方法里改变了mcm，其他地方，相应改变。
    // 按引用传递，可以不要返回值的
    private void parseModuleId(ModuleConfModel mcm, Context context) {
        context.init();
        ReadXmlExpression re = Parser.parse(new ModuleGenConfBuilder().addModuleGenConf().addDot().addId().build());
        String[] ss = re.interpret(context);

        mcm.setModuleId(ss[0]);

    }

    ////// ---------------------MapNeedGenTypes---------------------------

    private Map<String, List<String>> parseNeedGenTypes(Context context) {

        context.init();

        Map<String, List<String>> map = new HashMap<>();

        ReadXmlExpression re = Parser.parse(new ModuleGenConfBuilder().addModuleGenConf().addSeparator()
                .addNeedGenTypes().addSeparator().addNeedGenType().addDollar().addDot().addId().addDollar().build());
        String[] needGenTypes = re.interpret(context);

        for (String needGenId : needGenTypes) {
            map.put(needGenId, parseNeedGenOutTypes(context, needGenId));
        }

        return map;
    }

    private List<String> parseNeedGenOutTypes(Context context, String needGenId) {
        context.init();
        List<String> list = new ArrayList<>();

        ReadXmlExpression re = Parser.parse(new ModuleGenConfBuilder().addModuleGenConf().addSeparator()
                .addNeedGenTypes().addSeparator().addNeedGenType().addDollar().addOpenBracket().addId().addEqual()
                .addOtherValue(needGenId).addCloseBracket().addSeparator().addNeedGenOutType().addDollar().addDot()
                .addId().addDollar().build());

        String[] ss = re.interpret(context);

        for (String s : ss) {
            list.add(s);
        }

        return list;
    }

    ////// ---------------------MapExtends---------------------------

    private Map<String, ExtendConfModel> parseMapExtends(Map<String, String> param) {
        Map<String, ExtendConfModel> map = new HashMap<>();

        String[] extendIds = parseExtendIds(this.getContext(param));
        String[] isSingles = parseIsSingles(this.getContext(param));
        String[] values = null;

        for (int i = 0; i < extendIds.length; i++) {
            ExtendConfModel ecm = new ExtendConfModel();

            ecm.setId(extendIds[i]);
            ecm.setSingle(Boolean.parseBoolean(isSingles[i]));
            ecm.setValue(values[i]);

            if (!ecm.isSingle()) {
                ecm.setValues(ecm.getValue().split(ExpressionEnum.comma.getExpr()));
            }

            map.put(ecm.getId(), ecm);
        }

        return map;
    }

    private String[] parseExtendIds(Context context) {
        context.init();

        ReadXmlExpression re = Parser.parse(new ModuleGenConfBuilder().addModuleGenConf().addSeparator()
                .addExtendConfs().addSeparator().addExtendConf().addDollar().addDot().addId().addDollar().build());

        return re.interpret(context);
    }

    private String[] parseIsSingles(Context context) {
        context.init();

        ReadXmlExpression re = Parser
                .parse(new ModuleGenConfBuilder().addModuleGenConf().addSeparator().addExtendConfs().addSeparator()
                        .addExtendConf().addDollar().addDot().addIsSingle().addDollar().build());

        return re.interpret(context);
    }

}
