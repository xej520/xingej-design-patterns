package com.xingej.xgen.genconf.implementors.xmlimpl;

import java.util.List;
import java.util.Map;

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
        return null;
    }

    @Override
    public Map<String, ExtendConfModel> getMapExtends(Map<String, String> param) {
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

}
