package com.xingej.xgen.util.readxml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * 上下文，存放解释器需要的一些全局信息
 * 
 * 注意： 以前经常用的全局变量 与 现在的上下文 都是全局信息
 * 
 * @author erjun 2017年12月2日 上午9:36:13
 */
public class Context {

    private Document document = null;

    // 上一次被处理的多个父节点的元素集合
    private List<Element> parentEles = new ArrayList<>();

    // 提供缓存
    private static Map<String, Context> mapCtx = new HashMap<>();

    private Context(Document document) {
        this.document = document;
    }

    public static Context getInstance(String fileName) throws Exception {
        Context context = mapCtx.get(fileName);

        // 当然，不是线程安全的，
        if (null == context) {
            Document document = XmlUtil.getDocument(fileName);

            context = new Context(document);
            mapCtx.put(fileName, context);
            return context;
        }

        // 先初始化一下
        context.init();

        return context;
    }

    // 取出父级元素
    public List<Element> getParentEles() {
        return this.parentEles;
    }

    public void setParentEles(List<Element> parentEles) {
        this.parentEles = parentEles;
    }

    public void init() {
        parentEles = new ArrayList<>();
    }

    public Document getDcoument() {
        return this.document;
    }

    public List<Element> getNowFiles(Element parentEle, String eleName) {
        ArrayList<Element> nowFiles = new ArrayList<>();

        NodeList childNodes = parentEle.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i) instanceof Element) {
                Element element = (Element) childNodes.item(i);
                if (element.getTagName().equals(eleName)) {
                    nowFiles.add(element);
                }

            }
        }

        return nowFiles;
    }

    /**
     * 
     * 目前只是实现了判断某个元素的属性等于某个条件值的情况
     * 
     * @param element
     * @param condition
     * @return
     */
    public boolean judgeCondition(Element element, String condition) {
        // 当用户，没有写条件时，就为true，全部通过
        if (null == condition || condition.trim().length() == 0) {
            return true;
        }

        String[] ss = condition.split("=");

        if (ss.length == 2 && null != ss[1] && ss[1].equals(element.getAttribute(ss[0]))) {
            return true;
        }

        return false;
    }

}
