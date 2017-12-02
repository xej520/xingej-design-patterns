package com.xingej.xgen.util.readxml;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

public class ElementExpression extends ReadXmlExpression {
    // 用来记录/存储当前元素的子ReadXmlExpression元素
    private List<ReadXmlExpression> eles = new ArrayList<>();

    // 元素的名称
    private String eleName;

    // 判断的条件，就是 [id=e1]
    // root/a/e$[id=e1]/f
    private String condition = "";

    public ElementExpression(String eleName, String condition) {
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
        // 1.1 先取出父元素
        List<Element> parentEles = context.getParentEles();

        Element ele;

        // 存储的是，父元素 对应的子元素
        List<Element> nowEles = new ArrayList<>();

        if (parentEles.size() == 0) {
            // 1.2 判断父元素是否存在，如果不存在，表示当前处理的节点是根元素
            ele = context.getDcoument().getDocumentElement();
            parentEles.add(ele);
            context.setParentEles(parentEles);

        } else {
            // 1.3 如果存在的话，那么就应该找到当前表达式所对应的元素，把这个元素设置成父级节点，作为下一次解析的父级节点
            for (Element parentElement : parentEles) {
                nowEles.addAll(context.getNowFiles(parentElement, eleName));

                // 找到了当前表达式所对应的元素
                if (nowEles.size() > 0) {
                    // 找到一个就停止
                    break;
                }
            }

            if (nowEles.size() > 0 && context.judgeCondition(nowEles.get(0), condition)) {
                List<Element> tempEles = new ArrayList<>();

                tempEles.add(nowEles.get(0));

                context.setParentEles(tempEles);
            }
        }

        String[] ss = null;

        // 2、循环解释子元素
        for (ReadXmlExpression tempEle : eles) {
            ss = tempEle.interpret(context);
        }

        return ss;
    }
}
