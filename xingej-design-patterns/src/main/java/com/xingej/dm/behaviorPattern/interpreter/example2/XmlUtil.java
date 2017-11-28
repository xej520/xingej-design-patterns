package com.xingej.dm.behaviorPattern.interpreter.example2;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

/**
 * 提炼出，读取XML文件的工具类
 * 
 * @author erjun 2017年11月28日 上午8:34:02
 */
public class XmlUtil {
    public static Document getRoot(String fileName) throws Exception {
        Document document = null;
        // 建立一个解析器工厂
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // 获得一个DocumentBuilder对象，这个对象代表了具体的DOM解析器
        DocumentBuilder builder = factory.newDocumentBuilder();
        // 得到一个表示XML文档的Document对象
        document = builder.parse(fileName);
        // 去掉XML文档中作为格式化内容的空白而映射在DOM树中的不必要的Text Node对象
        document.normalize();
        return document;
    }
}
