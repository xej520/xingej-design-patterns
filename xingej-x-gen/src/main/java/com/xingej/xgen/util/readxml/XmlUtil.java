package com.xingej.xgen.util.readxml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class XmlUtil {
    public static Document getDocument(String fileName) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        // XmlUtil.class.getClassLoader().getResourceAsStream(fileName)
        // 表示，解析的是，当前路径下的文件
        // 调用时，输入 相对路径即可了
        Document document = documentBuilder.parse(XmlUtil.class.getClassLoader().getResourceAsStream(fileName));

        document.normalize();

        return document;
    }
}
