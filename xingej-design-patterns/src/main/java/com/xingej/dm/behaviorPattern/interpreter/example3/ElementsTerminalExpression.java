package com.xingej.dm.behaviorPattern.interpreter.example3;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

/**
 * 以多个元素作为终结符的解释器处理对象
 * 
 * @author erjun 2017年11月29日 上午9:03:02
 */
public class ElementsTerminalExpression extends ReadXmlExpression {

    private String eleName = "";

    public ElementsTerminalExpression(String eleName) {
        this.eleName = eleName;
    }

    @Override
    public String[] interpret(Context context) {
        // 先取出上下文里的父级元素
        List<Element> pEles = context.getPreEles();
        // 获取当前的多个元素
        List<Element> nowEles = new ArrayList<>();

        for (Element element : pEles) {
            nowEles.addAll(context.getNowEles(element, eleName));
        }

        // 然后需要去获取这些元素的值
        String[] ss = new String[nowEles.size()];
        for (int i = 0; i < ss.length; i++) {
            ss[i] = nowEles.get(i).getFirstChild().getNodeValue();
        }

        return ss;
    }

}
