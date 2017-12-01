package com.xingej.dm.behaviorPattern.interpreter.example3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.w3c.dom.Element;

/**
 * 
 * 单个元素 作为 非终结符的解释器
 * 
 * @author erjun 2017年11月29日 上午7:03:14
 */
public class ElementExpression extends ReadXmlExpression {

    // 用来记录组合的ReadXmlExpression元素
    private Collection<ReadXmlExpression> eles = new ArrayList<>();

    // 当前元素的名称
    private String eleName;

    public ElementExpression(String eleName) {
        this.eleName = eleName;
    }

    public boolean addEle(ReadXmlExpression ele) {
        this.eles.add(ele);
        return true;
    }

    public boolean removeEle(ReadXmlExpression ele) {
        this.eles.remove(ele);
        return true;
    }

    public String[] interpret(Context c) {
        // 先取出上下文里的父级元素
        List<Element> pEles = c.getPreEles();

        Element ele = null;

        // 把当前获取的元素放到上下文里面
        List<Element> nowEles = new ArrayList<>();
        if (pEles.size() == 0) {
            // 下面的语句是 获取的是根元素，如root
            ele = c.getDocument().getDocumentElement();

            System.out.println("-----根元素----:\t" + ele.getTagName()); // root
            System.out.println("-----根元素---id---:\t" + ele.getAttribute("id")); // rootId
            System.out.println("-----根元素---name-:\t" + ele.getAttribute("name"));// xingej

            // 将当前元素root，添加到 已处理过的容器pEles里
            pEles.add(ele);
            // 更新到上下文context的 preEles容器里
            c.setPreEles(pEles);
        } else {

            for (Element tempEle : pEles) {
                nowEles.addAll(c.getNowEles(tempEle, eleName));

                if (nowEles.size() > 0) {
                    break; // 找到一个就停止
                }
            }
            List<Element> tempList = new ArrayList<>();
            tempList.add(nowEles.get(0));
            c.setPreEles(tempList);
        }

        System.out.println("=========eles=====:\t" + eles.size());

        // 循环调用子元素的interpret方法
        String[] ss = null;
        for (ReadXmlExpression tempEle : eles) {
            ss = tempEle.interpret(c);
        }

        return ss;
    }

}
