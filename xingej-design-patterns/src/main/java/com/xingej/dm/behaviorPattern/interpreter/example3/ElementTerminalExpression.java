package com.xingej.dm.behaviorPattern.interpreter.example3;

import java.util.List;

import org.w3c.dom.Element;

/**
 * 元素作为终结符对应的解释器
 * 
 * @author erjun 2017年11月29日 下午2:25:06
 */
public class ElementTerminalExpression extends ReadXmlExpression {
    // 元素的名字
    private String eleName;

    public ElementTerminalExpression(String name) {
        this.eleName = name;
    }

    @Override
    public String[] interpret(Context context) {
        // 先取出上下文里的当前元素作为父级元素
        List<Element> preEles = context.getPreEles();

        // 查找到当前元素名称所对应的xml元素
        Element ele = null;
        if (preEles.size() == 0) {
            // 说明现在获取的是根元素
            ele = context.getDocument().getDocumentElement();
        } else {

            // 根据父级元素和要查找的元素的名称来获取当前的元素
            ele = context.getNowEles(preEles.get(0), eleName).get(0);
        }

        // 然后需要去获取这个元素的值
        String[] ss = new String[1];
        ss[0] = ele.getFirstChild().getNodeValue();

        return ss;
    }

}
