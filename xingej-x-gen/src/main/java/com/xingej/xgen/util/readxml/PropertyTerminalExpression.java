package com.xingej.xgen.util.readxml;

import org.w3c.dom.Element;

public class PropertyTerminalExpression extends ReadXmlExpression {

    // 属性的名字
    private String propName;

    public PropertyTerminalExpression(String propName) {
        super();
        this.propName = propName;
    }

    @Override
    public String[] interpret(Context context) {
        String[] ss = new String[1];
        // 1、 先获取父元素
        Element parentEle = context.getParentEles().get(0);

        // 2、直接获取该元素的属性的值
        ss[0] = parentEle.getAttribute(propName);

        return ss;
    }

}
