package com.xingej.dm.behaviorPattern.interpreter.example3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.w3c.dom.Element;

/**
 * 多个元素做为 非终结符的解释处理对象
 * 
 * @author erjun 2017年11月29日 下午2:14:47
 */
public class ElementsExpression extends ReadXmlExpression {

    // 用来记录组合的ReadXmlExpression元素
    private Collection<ReadXmlExpression> eles = new ArrayList<ReadXmlExpression>();

    /**
     * 元素名字
     */
    private String eleName = "";

    public ElementsExpression(String eleName) {
        this.eleName = eleName;
    }

    @Override
    public String[] interpret(Context context) {
        // 先取出上下文里的父级元素
        List<Element> pEles = context.getPreEles();

        // 把当前获取的元素放到上下文里面，这次是获取多个元素
        List<Element> nowEles = new ArrayList<>();
        for (Element ele : pEles) {
            nowEles.addAll(context.getNowEles(ele, eleName));
        }

        context.setPreEles(nowEles);

        // 循环调用子元素的interpret方法
        String[] ss = null;
        for (ReadXmlExpression ele : eles) {
            ss = ele.interpret(context);
        }

        return ss;
    }

    public Collection<ReadXmlExpression> getEles() {
        return eles;
    }

    public void setEles(Collection<ReadXmlExpression> eles) {
        this.eles = eles;
    }

    public String getEleName() {
        return eleName;
    }

    public void setEleName(String eleName) {
        this.eleName = eleName;
    }

}
