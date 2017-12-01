package com.xingej.dm.behaviorPattern.interpreter.example3;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * 用来包含 解析器 所需要的一些全局信息
 * 
 * @author erjun 2017年11月29日 上午7:17:01
 */

public class Context {
    // 上一个被处理的多个元素
    private List<Element> preEles = new ArrayList<Element>();

    // Dom解析XML的Document对象
    // 有了这个对象，就可以取出里面的标签属性了
    private Document document = null;

    /**
     * 构造方法
     * 
     * @param filePathName
     *            需要读取的xml的路径和名字
     * @throws Exception
     */
    public Context(String filePathName) throws Exception {
        // 通过辅助的Xml工具类来获取被解析的xml对应的Document对象
        this.document = XmlUtil.getRoot(filePathName);
    }

    /**
     * 重新初始化上下文
     */
    public void reInit() {
        preEles = new ArrayList<Element>();
    }

    /**
     * 各个Expression公共使用的方法, 根据父元素和当前元素的名称来获取当前的元素
     * 
     * @param pEle
     *            父元素
     * @param eleName
     *            当前元素的名称
     * @return 当前的多个元素的集合 // 父元素有很多子元素，跟指定元素名称相同的子元素集合
     *
     *         如：root有a,b,b,c,c,d,a,b 子元素，指定的元素名称eleName是b,
     * 
     *         那么，返回值就是[b,b,b] 的集合
     *
     */
    public List<Element> getNowEles(Element prElement, String eleName) {
        List<Element> elements = new ArrayList<>();

        System.out.println("----preElement---1--:\t" + prElement.getNodeName());

        // 父元素的 子元素
        NodeList tempNodeList = prElement.getChildNodes();
        for (int i = 0; i < tempNodeList.getLength(); i++) {
            if (tempNodeList.item(i) instanceof Element) {

                // 获取其中的每一个子元素
                Element nowEle = (Element) tempNodeList.item(i);

                System.out.println("----tagName----:\t" + nowEle.getTagName());

                // 校验 子元素的名称 是否 等价于指定的 元素名称
                if (nowEle.getTagName().equals(eleName)) {
                    elements.add(nowEle);
                }
            }
        }

        return elements;
    }

    public List<Element> getPreEles() {
        return preEles;
    }

    public void setPreEles(List<Element> preEles) {
        this.preEles = preEles;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Document getDocument() {
        return document;
    }

}
