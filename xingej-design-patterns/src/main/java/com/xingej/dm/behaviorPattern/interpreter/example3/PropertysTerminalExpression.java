package com.xingej.dm.behaviorPattern.interpreter.example3;

import java.util.List;

import org.w3c.dom.Element;

/**
 * 以多个元素的属性做为终结符的解释处理对象
 * 
 * @author erjun 2017年11月29日 下午2:08:11
 */
public class PropertysTerminalExpression extends ReadXmlExpression {

    /**
     * 属性名字
     */
    private String propName;

    public PropertysTerminalExpression(String propName) {
        this.propName = propName;
    }

    @Override
    public String[] interpret(Context context) {
        // 获取最后的多个元素
        List<Element> eles = context.getPreEles();
        String[] ss = new String[eles.size()];

        // 循环多个元素，获取每个的属性的值
        for (int i = 0; i < ss.length; i++) {
            ss[i] = eles.get(i).getAttribute(this.propName);
        }

        return ss;
    }

}
