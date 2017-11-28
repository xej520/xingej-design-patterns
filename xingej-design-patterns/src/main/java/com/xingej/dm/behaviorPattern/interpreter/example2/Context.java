package com.xingej.dm.behaviorPattern.interpreter.example2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * 用来包含 解析器 所需要的一些全局信息
 * 
 * @author erjun 2017年11月28日 上午8:35:08
 */
public class Context {
    // 上一个被处理的元素
    private Element preEle = null;

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
        preEle = null;
    }

    /**
     * 各个Expression公共使用的方法, 根据父元素和当前元素的名称来获取当前的元素
     * 
     * @param pEle
     *            父元素
     * @param eleName
     *            当前元素的名称
     * @return 找到的当前元素
     */
    public Element getNowEle(Element prElement, String eleName) {
        NodeList tempNodeList = prElement.getChildNodes();
        for (int i = 0; i < tempNodeList.getLength(); i++) {
            if (tempNodeList.item(i) instanceof Element) {
                Element nowEle = (Element) tempNodeList.item(i);
                System.out.println("----tagName----:\t" + nowEle.getTagName());
                if (nowEle.getTagName().equals(eleName)) {
                    return nowEle;
                }
            }
        }
        return null;
    }

    public Element getPreEle() {
        return preEle;
    }

    public void setPreEle(Element preEle) {
        this.preEle = preEle;
    }

    public Document getDocument() {
        return document;
    }

}
