package com.xingej.dm.behaviorPattern.interpreter.example2;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * 
 * @author erjun 2017年11月28日 下午1:59:08
 */
public class InterpretTest {

    private Context context;

    @Before
    public void testInit() throws Exception {
        // 准备上下文
        context = new Context("src/main/resources/InterpreterTest.xml");
    }

    // 想要获取c元素的值，也就是如下表达式的值:"root/a/b/c"
    @Test
    public void test() {
        // 首先要构建解释器的抽象语法树
        ElementExpression root = new ElementExpression("root");
        ElementExpression a = new ElementExpression("a");
        ElementExpression b = new ElementExpression("b");

        // 元素作为终结符对应的解释器
        ElementTerminalExpression cEle = new ElementTerminalExpression("c");

        // 组合起来
        root.addEle(a);
        a.addEle(b);
        b.addEle(cEle);

        // 调用解释器
        String[] ss = root.interpret(context);
        System.out.println("-----c的值是-----:\t" + ss[0]);

    }

}
