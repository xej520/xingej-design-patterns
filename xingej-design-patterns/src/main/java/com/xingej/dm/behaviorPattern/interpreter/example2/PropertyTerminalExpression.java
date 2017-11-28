package com.xingej.dm.behaviorPattern.interpreter.example2;

/**
 * 属性作为终结符 对应的解释器
 * 
 * @author erjun 2017年11月28日 上午9:21:53
 */
public class PropertyTerminalExpression extends ReadXmlExpression {

    /**
     * 属性的名字
     */
    private String propName;

    public PropertyTerminalExpression(String propName) {
        this.propName = propName;
    }

    @Override
    public String[] interpret(Context context) {
        String[] ss = new String[1];
        ss[0] = context.getPreEle().getAttribute(this.propName);

        return ss;
    }

}
