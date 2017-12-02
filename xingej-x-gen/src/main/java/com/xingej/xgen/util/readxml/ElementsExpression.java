package com.xingej.xgen.util.readxml;

import java.util.ArrayList;
import java.util.List;

public class ElementsExpression extends ReadXmlExpression {

    // 用来记录/存储当前元素的子ReadXmlExpression元素
    private List<ReadXmlExpression> eles = new ArrayList<>();

    @Override
    public String[] interpret(Context context) {
        return null;
    }

}
