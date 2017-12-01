package com.xingej.dm.behaviorPattern.interpreter.example3;

/**
 * 用于处理自定义Xml取值表达式的接口
 * 
 * @author erjun 2017年11月29日 上午9:07:29
 */
public abstract class ReadXmlExpression {
    /**
     * 解释表达式
     * 
     * @param c
     *            上下文
     * @return 解析过后的值，为了通用，可能是单个值，也可能是多个值， 因此就返回一个数组
     */
    public abstract String[] interpret(Context context);
}
