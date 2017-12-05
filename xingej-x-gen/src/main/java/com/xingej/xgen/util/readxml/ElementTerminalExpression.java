package com.xingej.xgen.util.readxml;

import java.util.List;

import org.w3c.dom.Element;

public class ElementTerminalExpression extends ReadXmlExpression {

    private String eleName;

    private String condition;

    public ElementTerminalExpression(String eleName, String condition) {
        super();
        this.eleName = eleName;
        this.condition = condition;
    }

    @Override
    public String[] interpret(Context context) {
        // 1、获取到自己这个元素
        // 先获取父元素，再传入自己的名称
        List<Element> parentElems = context.getParentEles();
        // 根据父元素，和 自己元素的名称，就可以查找到自己的元素
        Element ele = null;

        if (parentElems.size() == 0) {
            // 说明是根元素
            ele = context.getDcoument().getDocumentElement();

        } else {
            ele = context.getNowFiles(parentElems.get(0), eleName).get(0);

        }

        // 2、判断这个元素是否满足条件
        if (!context.judgeCondition(ele, condition)) {
            return new String[0];
        }
        // 3、获取这个元素的值
        String[] ss = new String[1];
        if (null != ele.getFirstChild()) {
            ss[0] = ele.getFirstChild().getNodeValue();
        } else {
            ss[0] = "";
        }

        return ss;
    }

    // 这里，仅仅实现，浅克隆，就可以了。
    @Override
    protected Object clone() throws CloneNotSupportedException {
        ElementTerminalExpression obj = null;

        try {
            // 1、 首先， 浅克隆，是将基本类型，进行了克隆，这里如：eleName, condition

            obj = (ElementTerminalExpression) super.clone();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }

}
