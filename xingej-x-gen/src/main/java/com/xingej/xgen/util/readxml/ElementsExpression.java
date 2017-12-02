package com.xingej.xgen.util.readxml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.w3c.dom.Element;

public class ElementsExpression extends ReadXmlExpression {

    // 用来记录/存储当前元素的子ReadXmlExpression元素
    private List<ReadXmlExpression> eles = new ArrayList<>();

    // 元素的名称
    private String eleName;

    // 判断的条件，就是 [id=e1]
    // root/a/e$[id=e1]/f
    private String condition = "";

    public ElementsExpression(String eleName, String condition) {
        this.eleName = eleName;
        this.condition = condition;
    }

    public void addEle(ReadXmlExpression ele) {
        this.eles.add(ele);
    }

    public boolean removeEle(ReadXmlExpression ele) {
        this.eles.remove(ele);
        return true;
    }

    public void removeAllEles() {
        this.eles.clear();
    }

    @Override
    public String[] interpret(Context context) {
        // 1、维护父级节点记录
        List<Element> parentEles = context.getParentEles();
        // 获取当前元素，多个
        List<Element> nowEles = new ArrayList<>();

        for (Element parentElement : parentEles) {
            nowEles.addAll(context.getNowFiles(parentElement, eleName));
        }
        // 判断条件
        Iterator<Element> it = nowEles.iterator();
        while (it.hasNext()) {
            Element ele = it.next();
            if (!context.judgeCondition(ele, condition)) {
                // 将不满足条件的移除
                it.remove();
            }
        }
        // 设置父节点
        context.setParentEles(nowEles);

        // 2、循环解释子元素
        String[] ss = null;

        for (ReadXmlExpression tempEle : eles) {
            ss = tempEle.interpret(context);
        }

        return ss;
    }

}
