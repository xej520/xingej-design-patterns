package com.xingej.csdn.utils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 工具类：读取XML配置文件
 * 
 * 目的：从配置文件里读取，当前要运行的子类
 * 
 * @author erjun 2017年12月16日 上午6:35:59
 */
public class XMLUtils {
    // 该方法用于从XML配置文件中提取图表类型，并返回类型名
    public static String getChartType() {
        try {
            // 创建文档对象
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder = dFactory.newDocumentBuilder();

            Document doc = builder.parse(
                    // 通过反射的方式来读取配置文件
                    // 当然，也可用通过new File("/src/main/resources/config.xml");
                    // 必须包含的是 绝对路径哦
                    Class.forName("com.xingej.csdn.utils.XMLUtils").getClassLoader().getResourceAsStream("config.xml"));

            // 获取包含图表类型的文本节点
            NodeList nl = doc.getElementsByTagName("chartType");

            Node classNode = nl.item(0).getFirstChild();

            String chartType = classNode.getNodeValue().trim();

            return chartType;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
