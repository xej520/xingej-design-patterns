package com.xingej.xgen.genconf.implementors.xmlimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xingej.xgen.genconf.implementors.GenConfImplementor;
import com.xingej.xgen.genconf.vo.NeedGenModel;
import com.xingej.xgen.genconf.vo.ThemeModel;
import com.xingej.xgen.util.readxml.Context;
import com.xingej.xgen.util.readxml.ParserWithMemento;
import com.xingej.xgen.util.readxml.ReadXmlExpression;

/**
 * 
 * @author erjun 2017年12月6日 下午9:32:53
 */
// 通过Parser去获取到配置的数据，然后，把这些数据组成GenConfImplementor所需要的样子
// GenConfXmlImpl 充当Parser的客户端
public class GenConfXmlImpl implements GenConfImplementor {

    // 1：通过builder来获取用于取值的字符串
    // 2：使用这些字符串，通过Parser去获取到配置的数据
    // 3：然后把这些数据组装成GenConfImplementor所需要的样子
    @Override
    public List<NeedGenModel> getNeedGens() {
        return readNeedGends();
    }

    @Override
    public List<ThemeModel> getThemeo() {
        return null;
    }

    @Override
    public Map<String, String> getMapConstants() {
        return null;
    }
    /////////////////////////////////////////////////////////////////////////

    private Context getContext() {
        Context context = null;

        try {
            // 下面的形式，还是自己去拼接的
            // context = Context.getInstance(ExpressionEnum.xmlFilePre.getExpr()
            // + GenConfEnum.GenConf
            // + ExpressionEnum.dot.getExpr() + ExpressionEnum.xml);

            // 下面使用builder进行拼接
            // 也就是buildder模式
            context = Context.getInstance(new GenConfBuilder().addXmlFilePre().addGenConf().addDot().addXml().build());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return context;
    }

    private List<NeedGenModel> readNeedGends() {

        List<NeedGenModel> retList = new ArrayList<>();
        Context context = getContext();

        // 分别获取相应的数据
        String[] needGenIds = parseNeedGenIds(context);
        String[] needGenProviders = parseNeedGenProviderss(context);
        String[] needGenThemes = parseNeedGenThemes(context);

        // 开始组装
        for (int i = 0; i < needGenIds.length; i++) {
            NeedGenModel ngm = new NeedGenModel();
            ngm.setId(needGenIds[i]);
            ngm.setProvider(needGenProviders[i]);
            ngm.setTheme(needGenThemes[i]);

            // 去获取参数的值
            String[] paramIds = parseParamIds(context, ngm.getId());
            String[] paramValues = parseParamValues(context, ngm.getId());

            // 组装param
            Map<String, String> mapParams = new HashMap<>();

            for (int j = 0; j < paramIds.length; j++) {
                mapParams.put(paramIds[j], paramValues[j]);
            }
            ngm.setMapParams(mapParams);

            // 把ngm加入到返回的list里面
            retList.add(ngm);
        }

        return retList;
    }
    
    private String[] parseNeedGenIds(Context context) {
        context.init();
        
        //拼接下面的字符串
        // genconf/needgens/needgen$.id$
        ReadXmlExpression re = ParserWithMemento.parseByMemento(
                
                new GenConfBuilder()
                .addGenConf()
                .addSeparator()
                .addNeedGens()
                .addSeparator()
                .addNeedGen()
                .addDollar()
                .addDot()
                .addId()
                .addDollar()
                .build());
        
        return re.interpret(context);
    }
    
    private String[] parseNeedGenProviderss(Context context) {
        context.init();
        
        //拼接下面的字符串
        // genconf/needgens/needgen$.id$
        ReadXmlExpression re = ParserWithMemento.parseByMemento(
                
                new GenConfBuilder()
                .addGenConf()
                .addSeparator()
                .addNeedGens()
                .addSeparator()
                .addNeedGen()
                .addDollar()
                .addDot()
                .addProvider()
                .addDollar()
                .build());
        
        return re.interpret(context);
    }
    private String[] parseNeedGenThemes(Context context) {
        context.init();
        
        //拼接下面的字符串
        // genconf/needgens/needgen$.id$
        ReadXmlExpression re = ParserWithMemento.parseByMemento(
                
                new GenConfBuilder()
                .addGenConf()
                .addSeparator()
                .addNeedGens()
                .addSeparator()
                .addNeedGen()
                .addDollar()
                .addDot()
                .addThemeId()
                .addDollar()
                .build());
        
        return re.interpret(context);
    }
    
    
    private String[] parseParamIds(Context context, String needGenId) {
        context.init();
        
        //拼接下面的字符串
   
        ReadXmlExpression re = ParserWithMemento.parseByMemento(
                
                new GenConfBuilder()
                .addGenConf()
                .addSeparator()
                .addNeedGens()
                .addSeparator()
                .addNeedGen()
                .addDollar()
                //添加参数
                .addOpenBracket().addId().addEqual().addOtherValue(needGenId).addCloseBracket()
                .addSeparator().addParams().addDollar().addSeparator().addParam().addDollar()
                .addDot()
                .addId()
                .addDollar()
                .build());
        
        return re.interpret(context);
    }
    
    private String[] parseParamValues(Context context, String needGenId) {
        context.init();
        
        //拼接下面的字符串
   
        ReadXmlExpression re = ParserWithMemento.parseByMemento(
                
                new GenConfBuilder()
                .addGenConf()
                .addSeparator()
                .addNeedGens()
                .addSeparator()
                .addNeedGen()
                .addDollar()
                //添加参数
                .addOpenBracket().addId().addEqual().addOtherValue(needGenId).addCloseBracket()
                .addSeparator().addParams().addDollar().addSeparator().addParam().addDollar()
         
                .build());
        
        return re.interpret(context);
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
