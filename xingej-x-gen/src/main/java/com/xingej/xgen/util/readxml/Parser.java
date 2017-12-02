package com.xingej.xgen.util.readxml;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 解析器
 * 
 * 将表达式 转换成 抽象树
 * 
 * @author erjun 2017年12月2日 下午8:55:13
 */
public class Parser {

    // 定义常量
    private static final String BACKLASH = "/";
    private static final String DOT = ".";
    private static final String DOLLAR = "$";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";

    // 构建工具类，
    // 构造方法私有化，不允许外界创建对象
    private Parser() {

    }

    /**
     * 根据传入的表达式，通过解析，组合成为一个抽象的语法树
     * 
     * @param expr
     *            要解析的表达式
     * @return 表达式对应的抽象语法树
     */
    // root/a/b/c
    public static ReadXmlExpression parse(String expr) {
        // 第一大步: 分解表达式，得到需要解析的元素名称和该元素对应的解析模型；
        // 就是，root 对应一个ParseModel, 你不能简简单单的写一个root,就可以了。
        // 同样，a 对应一个ParseModel

        Map<String, ParseModel> mapPath = parseMapPath(expr);

        // 第二大步：根据元素对应的解析模型，转换成，相应的解释器对象，如ElementExpression
        List<ReadXmlExpression> list = mapPath2Expression(mapPath);
        // 第三大步：按照先后顺序组成为抽象语法树
        ReadXmlExpression retTree = buildTree(list);
        return null;
    }

    // ----------------------------第一大步-------------------
    /**
     * 第一大步：
     * 
     * 按照从左到右的顺序来解析表达式，得到相应的元素名称和该元素对应的解析模型
     * 
     * @param expr
     * @return
     */
    private static Map<String, ParseModel> parseMapPath(String expr) {
        // root/a/b/c.name
        StringTokenizer tokenizer = new StringTokenizer(expr, BACKLASH);

        Map<String, ParseModel> mapPath = new HashMap<>();

        while (tokenizer.hasMoreTokens()) {
            String onePath = tokenizer.nextToken();

            if (tokenizer.hasMoreTokens()) {
                // 还有下一个，说明不是结尾

                setParsePath(onePath, false, false, mapPath);
            } else {
                // 说明 结尾了
                int dotIndex = onePath.indexOf(DOT);

                if (dotIndex > 0) {
                    // 说明是属性结尾
                    String eleName = onePath.substring(0, dotIndex);
                    String propName = onePath.substring(dotIndex + 1);
                    // 设置属性前面的元素
                    setParsePath(eleName, false, false, mapPath);

                    // 设置属性
                    setParsePath(propName, true, true, mapPath);
                } else {
                    // 说明是 元素结尾
                    setParsePath(onePath, true, false, mapPath);
                }
                // 已经解析到了结尾了，就退出吧
                break;
            }
        }

        return mapPath;
    }

    private static void setParsePath(String eleName, boolean end, boolean propertyValue,
            Map<String, ParseModel> mapPath) {
        ParseModel pm = new ParseModel();

        pm.setEnd(end);
        pm.setPropertyValue(propertyValue);
        pm.setSingleValue(!(eleName.indexOf(DOLLAR) > 0));

        // 去掉$
        eleName = eleName.replace(DOLLAR, "");

        // 条件设置
        int tempBegin = 0;
        int tempEnd = 0;

        if (((tempBegin = eleName.indexOf(OPEN_BRACKET)) > 0)) {
            tempEnd = eleName.indexOf(CLOSE_BRACKET);
            pm.setCondition(eleName.substring(tempBegin + 1, tempEnd));

            eleName = eleName.substring(0, tempBegin);
        } else {
            // 名称设置
            pm.setEleName(eleName);
        }

        mapPath.put(eleName, pm);
    }

    // ----------------------------第二大步-------------------
    /**
     * 第二大步：根据元素对应的解析模型，转换成，相应的解释器对象，如ElementExpression
     * 
     * @param mapPath
     * @return
     */
    private static List<ReadXmlExpression> mapPath2Expression(Map<String, ParseModel> mapPath) {

        return null;
    }

    // ----------------------------第三大步-------------------

    /**
     * 第三大步：按照先后顺序组成为抽象语法树
     * 
     * @param listExpression
     * @return
     */
    private static ReadXmlExpression buildTree(List<ReadXmlExpression> listExpression) {

        return null;
    }

}
