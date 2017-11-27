package com.xingej.dm.behaviorPattern.interpreter.example1;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
        doc = builder.parse("src/main/resources/App2.xml");
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

    @Test
    public void testDriverClass() throws Exception {
        NodeList jdbc = doc.getElementsByTagName("jdbc");

        NodeList driverClass = ((Element) jdbc.item(0)).getElementsByTagName("driver-class");
        Node item = driverClass.item(0);
        System.out.println("---driverClass---nodeValue---:\t" + item.getFirstChild().getNodeValue());

    }

    @Test
    public void testURL() throws Exception {
        NodeList jdbc = doc.getElementsByTagName("jdbc");

        NodeList driverClass = ((Element) jdbc.item(0)).getElementsByTagName("url");
        Node item = driverClass.item(0);
        System.out.println("---url---nodeValue---:\t" + item.getFirstChild().getNodeValue());

    }

    @Test
    public void testUser() throws Exception {
        NodeList jdbc = doc.getElementsByTagName("jdbc");

        NodeList driverClass = ((Element) jdbc.item(0)).getElementsByTagName("user");
        Node item = driverClass.item(0);
        System.out.println("---user---nodeValue---:\t" + item.getFirstChild().getNodeValue());

    }

    @Test
    public void testPassword() throws Exception {
        NodeList jdbc = doc.getElementsByTagName("jdbc");

        NodeList driverClass = ((Element) jdbc.item(0)).getElementsByTagName("password");
        Node item = driverClass.item(0);
        System.out.println("---password---nodeValue---:\t" + item.getFirstChild().getNodeValue());

    }

    @Test
    public void testApplicationXml() throws Exception {
        NodeList jdbc = doc.getElementsByTagName("application-xml");

        System.out.println("---password---nodeValue---:\t" + jdbc.item(0).getFirstChild().getNodeValue());

    }

    @Test
    public void testRoot() throws Exception {
        NodeList root = doc.getElementsByTagName("root");

        System.out.println("---password---nodeValue---:\t" + root.item(0));

    }

    // ---------------------测试读取App2.xml配置文件------------------

    @Test
    public void testQuery() throws Exception {
        NodeList nodes = doc.getElementsByTagName("spring-default");
        System.out.println("----length---:\t" + nodes.getLength());

        NodeList appXmlsNode = ((Element) nodes.item(0)).getElementsByTagName("application-xmls");
        System.out.println("----length----:\t" + appXmlsNode.getLength());
        System.out.println("----length----:\t" + ((Element) nodes.item(0)).getNodeType());

        NodeList appXmlNode = ((Element) appXmlsNode.item(0)).getElementsByTagName("application-xml");
        System.out.println("----length----:\t" + appXmlNode.getLength());

        for (int i = 0; i < appXmlNode.getLength(); i++) {
            Node firstChild = appXmlNode.item(i).getFirstChild();
            System.out.println("---firstChild--parentNode---:\t" + firstChild.getParentNode());
            System.out.println("---firstChild--nodeType---:\t" + firstChild.getNodeType());
            System.out.println("---firstChild--NodeName---:\t" + firstChild.getNodeName());
            System.out.println("---firstChild--NodeValue---:\t" + firstChild.getNodeValue());
            System.out.println("---firstChild--BaseURI---:\t" + firstChild.getBaseURI());
        }
    }

}
