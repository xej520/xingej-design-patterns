package com.xingej.dm.behaviorPattern.interpreter.example3;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * 
 * @author erjun 2017年11月29日 下午2:27:24
 */
public class InterpretTest {

    private Context context;

    @Before
    public void testInit() throws Exception {
        // 准备上下文
        context = new Context("src/main/resources/InterpreterTest.xml");
    }

    @Test
    public void test() {
        // 想要获取多个d元素的值，也就是如下表达式的值："root/a/b/d$"
        // 首先，要构建解释器的抽象语法树
        ElementExpression root = new ElementExpression("root");
        ElementExpression aEle = new ElementExpression("a");
        ElementExpression bEle = new ElementExpression("b");

        ElementsTerminalExpression dEle = new ElementsTerminalExpression("d");

        // 组合起来, 变成 抽象树
        root.addEle(aEle);
        aEle.addEle(bEle);
        bEle.addEle(dEle);

        System.out.println("------解析前---context---preEles:\t" + context.getPreEles());

        // 调用
        String[] ss = root.interpret(context);
        for (String s : ss) {
            System.out.println("---->:\t" + s);
        }
    }

}
