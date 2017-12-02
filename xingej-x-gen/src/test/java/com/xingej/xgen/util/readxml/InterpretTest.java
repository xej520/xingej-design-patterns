package com.xingej.xgen.util.readxml;

import org.junit.Test;

/**
 * 
 * 1、表达式 ---->转换成---->抽象语法树----->由解析器去完成
 * 
 * 2、抽象语法树---->由解释器模式去解释执行
 * 
 * 解析器 本身 不是 解释器模式里的内容
 * 
 * @author erjun 2017年12月2日 下午2:40:41
 */
public class InterpretTest {

    // 下面的两个测试用例，都是用 手工完成的，表达式 到 抽象语法树的工作的

    // 测试元素作为非终结符,以及元素作为终结符的测试用例
    // 抽象语法树：---->GenConf/NeedGens/NeedGen/Params/Param
    @Test
    public void test() throws Exception {
        // 构建元素对象
        ElementExpression genConf = new ElementExpression("GenConf", "");
        ElementExpression needGens = new ElementExpression("NeedGens", "");
        ElementExpression needGen = new ElementExpression("NeedGen", "");
        ElementExpression params = new ElementExpression("Params", "");

        ElementTerminalExpression param = new ElementTerminalExpression("Param", "");

        // 构建抽象语法树
        genConf.addEle(needGens);
        needGens.addEle(needGen);
        needGen.addEle(params);
        params.addEle(param);

        // 创建下文对象
        Context context = Context.getInstance("xgenconfxml/GenConf.xml");

        // 开始解析
        String[] ss = genConf.interpret(context);

        // 打印结果
        System.out.println("---->:\t" + ss[0]);
    }

    // 测试，以属性作为终结符的测试用例
    @Test
    public void testProperties() throws Exception {
        // 构建元素对象
        ElementExpression genConf = new ElementExpression("GenConf", "");
        ElementExpression themes = new ElementExpression("Themes", "");
        ElementExpression theme = new ElementExpression("Theme", "");

        PropertyTerminalExpression id = new PropertyTerminalExpression("id");

        // 构建抽象语法树
        genConf.addEle(themes);
        themes.addEle(theme);
        theme.addEle(id);

        // 创建下文对象
        Context context = Context.getInstance("xgenconfxml/GenConf.xml");

        // 开始解析
        String[] ss = genConf.interpret(context);

        // 打印结果
        System.out.println("---->:\t" + ss[0]);
    }

}
