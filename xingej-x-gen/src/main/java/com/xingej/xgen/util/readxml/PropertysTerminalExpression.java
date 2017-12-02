package com.xingej.xgen.util.readxml;

import java.util.List;

import org.w3c.dom.Element;

public class PropertysTerminalExpression extends ReadXmlExpression {
    // 属性的名字
    private String propName;

    public PropertysTerminalExpression(String propName) {
        super();
        this.propName = propName;
    }

    @Override
    public String[] interpret(Context context) {
        // 1、获取父元素
        List<Element> parentEles = context.getParentEles();

        String[] ss = new String[parentEles.size()];

        for (int i = 0; i < ss.length; i++) {
            ss[i] = parentEles.get(i).getAttribute(propName);
        }

        return ss;
    }
}
