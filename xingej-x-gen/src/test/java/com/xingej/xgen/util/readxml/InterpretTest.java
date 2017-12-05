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

    // 测试，获取多个相同元素的值
    @Test
    public void testMulElement() throws Exception {
        // 构建元素对象
        ElementExpression genConf = new ElementExpression("GenConf", "");
        ElementExpression constants = new ElementExpression("Constants", "");
        ElementsTerminalExpression constant = new ElementsTerminalExpression("Constant", "");

        // 构建抽象语法树
        genConf.addEle(constants);
        constants.addEle(constant);

        // 创建下文对象
        Context context = Context.getInstance("xgenconfxml/GenConf.xml");

        // 开始解析
        String[] ss = genConf.interpret(context);

        // 打印结果
        for (String s : ss) {
            System.out.println("---->:\t" + s);
        }

    }

    // 测试，获取多个属性的值
    @Test
    public void testMulProperties() throws Exception {
        // 构建元素对象
        ElementExpression genConf = new ElementExpression("GenConf", "");
        ElementExpression needGens = new ElementExpression("NeedGens", "");
        ElementExpression needGen = new ElementExpression("NeedGen", "");
        ElementExpression params = new ElementExpression("Params", "");

        ElementsExpression param = new ElementsExpression("Param", "");

        // 你要取的是，多个id的值，一个id属性对应一个Param
        // 因此，上面用的是ElementsExpression，多个元素作为非终结符
        PropertysTerminalExpression ids = new PropertysTerminalExpression("id");

        // 构建抽象语法树
        genConf.addEle(needGens);
        needGens.addEle(needGen);
        needGen.addEle(params);
        params.addEle(param);
        param.addEle(ids);

        // 创建下文对象
        Context context = Context.getInstance("xgenconfxml/GenConf.xml");

        // 开始解析
        String[] ss = genConf.interpret(context);

        // 打印结果
        for (String s : ss) {
            System.out.println("---->:\t" + s);
        }

    }

    // 测试，添加条件测试
    @Test
    public void testCondition() throws Exception {
        // 构建元素对象
        ElementExpression genConf = new ElementExpression("GenConf", "");
        ElementExpression needGens = new ElementExpression("NeedGens", "");
        ElementExpression needGen = new ElementExpression("NeedGen", "");
        ElementExpression params = new ElementExpression("Params", "");

        // 添加，限制条件id=fileName2
        // 也就是说，只获取id= fileName2的值
        ElementsTerminalExpression param = new ElementsTerminalExpression("Param", "id=fileName2");

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
        for (String s : ss) {
            System.out.println("---->:\t" + s);
        }

    }

    // 测试，解析器
    @Test
    public void testBy解析器() throws Exception {

        // 创建下文对象
        Context context = Context.getInstance("xgenconfxml/GenConf.xml");

        // String expression =
        // "GenConf/NeedGens/NeedGen/Params/Param[id=fileName1]";
        // String expression = "GenConf/NeedGens/NeedGen/Params/Param";
        // String expression = "GenConf/NeedGens/NeedGen/Params/Param$";
        // String expression = "GenConf/NeedGens/NeedGen/Params/Param$.id$";
        String expression = "GenConf/NeedGens/NeedGen/Params/Param[id=fileName1]";

        ReadXmlExpression parse = Parser.parse(expression);

        // 开始解析
        String[] ss = parse.interpret(context);

        // 打印结果
        for (String s : ss) {
            System.out.println("---->:\t" + s);
        }

    }

}
