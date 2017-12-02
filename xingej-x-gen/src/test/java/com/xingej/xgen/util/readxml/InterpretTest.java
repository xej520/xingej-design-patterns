package com.xingej.xgen.util.readxml;

import org.junit.Test;

public class InterpretTest {

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

}
