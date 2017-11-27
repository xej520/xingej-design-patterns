package com.xingej.dm.behaviorPattern.interpreter.example1;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadAppXmlTest {
    private Document doc;

    @Before
    public void init() throws Exception {
        // 建立一 个解析器工厂
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // 获得一个DocumentBuilder对象，这个对象代表了具体的DOM解析器
        DocumentBuilder builder = factory.newDocumentBuilder();
        // 得到一个表示XML文档的Document对象
        doc = builder.parse("src/main/resources/App.xml");
        // 去掉XML文档中作为格式化内容的空白而映射在DOM树中的不必要的Text Node对象
        doc.normalize();
    }

    @Test
    public void test() throws Exception {
        NodeList elementsByTagName = doc.getElementsByTagName("jdbc");
        Node item = elementsByTagName.item(0);
        System.out.println("----length----:\t" + elementsByTagName.getLength());
        System.out.println("----nodeType-----:\t" + item.getNodeType());
        System.out.println("----nodeName-----:\t" + item.getNodeName());
        System.out.println("----nodeValue-----:\t" + item.getNodeValue());
    }
}
