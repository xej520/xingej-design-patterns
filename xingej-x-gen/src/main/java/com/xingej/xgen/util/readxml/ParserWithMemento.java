package com.xingej.xgen.util.readxml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 解析器：
 * 
 * 带有备忘录哦
 * 
 * @author erjun 2017年12月3日 下午3:40:17
 */
public class ParserWithMemento {

    // 定义常量
    private static final String BACKLASH = "/";
    private static final String DOT = ".";
    private static final String DOLLAR = "$";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";

    // 存储的是，按照分解的先后顺序的元素所对应的路径
    private static List<String> listElePath = null;

    // 构建工具类，
    // 构造方法私有化，不允许外界创建对象
    private ParserWithMemento() {

    }

    //////////////////// ------备忘录模式--开始部分----///////////////////
    // Parser.java类，就相当于 源发器，在源发器里，实现，静态内部类
    private static class MementoImpl implements ParseMemento {
        // 存储的是 抽象语法树
        private Map<String, ReadXmlExpression> mapRe = new HashMap<>();

        public MementoImpl(Map<String, ReadXmlExpression> mapRe) {
            this.mapRe = mapRe;
        }

        public Map<String, ReadXmlExpression> getMapRe() {
            return mapRe;
        }
    }

    /**
     * 根据传入的表达式，通过解析，组合成为一个抽象的语法树
     * 
     * @param expr
     *            要解析的表达式
     * @return 表达式对应的抽象语法树
     */
    // 通过备忘录模式，进行解析
    public static ReadXmlExpression parseByMemento(String expr) {
        // 1：应该获取备忘录对象
        ParseMemento memento = ParseCaretaker.getInstance().retriveMemento();
        // 2:从备忘录中获取数据
        Map<String, ReadXmlExpression> mapRe = null;
        if (null == memento) {
            mapRe = new HashMap<>();

        } else {
            mapRe = ((MementoImpl) memento).getMapRe();
        }
        // 3:从缓存里面找到最长的相同的string来，这部分就不需要解析了
        String notParseExpre = searchMaxLongEquals(expr, mapRe);
        // 4:获取剩下的需要解析的部分
        String needParseExpr = "";
        if (notParseExpre.trim().length() == 0) {
            needParseExpr = expr;
        } else {
            if (notParseExpre.length() < expr.length()) {
                needParseExpr = expr.substring(notParseExpre.length() + 1);
            } else {
                needParseExpr = "";
            }
        }
        // 5:真正解析剩下的需要解析的String

        if (needParseExpr.trim().length() > 0) {
            ReadXmlExpression re = parse(needParseExpr);
        }

        // 6:把两个部分的抽象语法树合并起来

        return null;
    }

    /**
     * 获取最长的已经解析过的字符串
     * 
     * @param expr
     * @param mapRe
     * @return
     */
    private static String searchMaxLongEquals(String expr, Map<String, ReadXmlExpression> mapRe) {
        boolean flag = mapRe.containsKey(expr);

        while (!flag) {
            int lastIndex = expr.lastIndexOf(BACKLASH);
            if (lastIndex > 0) {
                expr = expr.substring(0, lastIndex);
                flag = mapRe.containsKey(expr + BACKLASH);
            } else {
                expr = "";
                flag = true;
            }

        }

        return expr;
    }

    //////////////////// ------备忘录模式--结束部分----///////////////////

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
        Map<String, ReadXmlExpression> list = mapPath2Expression(mapPath);
        // 第三大步：按照先后顺序组成为抽象语法树
        ReadXmlExpression retTree = buildTree(list);

        return retTree;
    }

    // ----------------------------第一大步-------------------
    /**
     * 第一大步：
     * 
     * 按照从左到右的顺序来解析表达式，得到相应的元素的路径和该元素对应的解析模型
     * 
     * @param expr
     * @return
     */
    private static Map<String, ParseModel> parseMapPath(String expr) {
        listElePath = new ArrayList<>();

        // root/a/b/c.name
        Map<String, ParseModel> mapPath = new HashMap<>();

        // 从根开始的前缀路径
        StringBuffer pathBuffer = new StringBuffer();

        StringTokenizer tokenizer = new StringTokenizer(expr, BACKLASH);

        while (tokenizer.hasMoreTokens()) {
            String onePath = tokenizer.nextToken();

            if (tokenizer.hasMoreTokens()) {
                // 还有下一个，说明不是结尾

                pathBuffer.append(onePath + BACKLASH);
                setParsePath(pathBuffer, onePath, false, false, mapPath);
            } else {
                // 说明 结尾了
                int dotIndex = onePath.indexOf(DOT);

                if (dotIndex > 0) {
                    // 说明是属性结尾
                    String eleName = onePath.substring(0, dotIndex);
                    String propName = onePath.substring(dotIndex + 1);

                    // 设置路径
                    pathBuffer.append(eleName + DOT);
                    // 设置属性前面的元素
                    setParsePath(pathBuffer, eleName, false, false, mapPath);

                    // 设置路径
                    pathBuffer.append(propName);
                    // 设置属性
                    setParsePath(pathBuffer, propName, true, true, mapPath);
                } else {

                    // 设置路径
                    pathBuffer.append(onePath);

                    // 说明是 元素结尾
                    setParsePath(pathBuffer, onePath, true, false, mapPath);
                }

                // 已经解析到了结尾了，就退出吧
                break;
            }
        }

        return mapPath;
    }

    private static void setParsePath(StringBuffer buffer, String eleName, boolean end, boolean propertyValue,
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
        }

        // 名称设置
        pm.setEleName(eleName);

        mapPath.put(buffer.toString(), pm);

        listElePath.add(buffer.toString());
    }

    // ----------------------------第二大步-------------------
    /**
     * 第二大步：根据元素对应的解析模型，转换成，相应的解释器对象，如ElementExpression
     * 
     * @param mapPath
     * @return
     */
    private static Map<String, ReadXmlExpression> mapPath2Expression(Map<String, ParseModel> mapPath) {
        Map<String, ReadXmlExpression> result = new HashMap<>();
        // 一定要按照分解的先后顺序，来转换成相应的解释器对象
        for (String key : listElePath) {
            ParseModel pm = mapPath.get(key);
            ReadXmlExpression obj = parseModel2ReadXmlExpression(pm);

            result.put(key, obj);

        }

        // 一个key, 对应一个对象，也就是说，一个路径，对应一个对象
        return result;
    }

    private static ReadXmlExpression parseModel2ReadXmlExpression(ParseModel pm) {
        ReadXmlExpression obj = null;

        if (!pm.isEnd()) {
            if (pm.isSingleValue()) { // 非结尾的，就是单个元素的非终结符
                obj = new ElementExpression(pm.getEleName(), pm.getCondition());
            } else {
                obj = new ElementsExpression(pm.getEleName(), pm.getCondition());
            }
        } else if (pm.isPropertyValue()) {

            if (pm.isSingleValue()) {// 单个属性结尾
                obj = new PropertyTerminalExpression(pm.getEleName());
            } else {
                obj = new PropertysTerminalExpression(pm.getEleName());
            }

        } else {
            if (pm.isSingleValue()) {// 单个属性结尾
                obj = new ElementTerminalExpression(pm.getEleName(), pm.getCondition());
            } else {
                obj = new ElementsTerminalExpression(pm.getEleName(), pm.getCondition());
            }
        }

        return obj;
    }

    // ----------------------------第三大步-------------------

    /**
     * 第三大步：按照先后顺序组成为抽象语法树
     * 
     * @param listExpression
     * @return
     */
    private static ReadXmlExpression buildTree(String prefixStr, ReadXmlExpression prefixRe,
            Map<String, ReadXmlExpression> mapPathAndRe, Map<String, ReadXmlExpression> mapRe) {
        // 第一个对象，也就是根对象，返回去的对象
        ReadXmlExpression retRe = prefixRe; // 设置初始值
        // 用来临时记录，上一个元素，作为父元素
        ReadXmlExpression preEle = getLastRE(prefixRe);

        for (String path : listElePath) {
            ReadXmlExpression re = mapPathAndRe.get(path);

            // 说明当前元素，re是根元素
            if (null == preEle) {
                retRe = re; // 设置返回去的元素
                preEle = re; // 将当前元素，设置为父元素
            } else {
                // 把当前元素添加到父元素的下面，同时把自己设置成父元素
                // 对当前元素的类型，进行判断
                if (preEle instanceof ElementExpression) {
                    ElementExpression elementExpression = (ElementExpression) preEle;
                    // 将当前元素，添加到父元素的下面
                    elementExpression.addEle(re);

                    // 并且，将当前元素，作为前一个元素，也就是作为父级元素
                    preEle = elementExpression;

                } else if (preEle instanceof ElementsExpression) {
                    ElementsExpression eles = (ElementsExpression) preEle;
                    eles.addEle(re);

                    preEle = eles;
                }

            }
            // 每次生成一个新的抽象树对象，就应该添加到缓存里面， 应该是把retRe克隆一份
            if (null != prefixStr && prefixStr.trim().length() > 0) {
                // value的值，应该是， 数据是一样一样的，只是引用不一样，
                // java传的是应用，不然，前面上传到mapRe里了，
                // 后面，很有可能将value的值修改，那么前面的路径就没有用了，
                // 因此，这里，要使用克隆模式

                try {
                    mapRe.put(prefixStr + BACKLASH + path, (ReadXmlExpression) retRe.clone());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                // 如果前缀为空，没有匹配上的
                try {
                    mapRe.put(path, (ReadXmlExpression) retRe.clone());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        return retRe;
    }

    // 从树里，将最后一个元素，找出来
    /**
     * 获取已经解析过的对象树的最后一个元素对象
     * 
     * @param prefixRe
     * @return
     */
    private static ReadXmlExpression getLastRE(ReadXmlExpression prefixRe) {
        ReadXmlExpression lastRe = prefixRe;

        boolean flag = true;

        // a/b/c/d
        while (flag) {
            // lastRe为a
            if (lastRe instanceof ElementExpression) {
                // 说明lastRe元素下面，还有子元素哦
                if (((ElementExpression) lastRe).getEles().size() > 0) {
                    // 取出子元素,此时lastRe 为b
                    // 替换成子元素，再等于用循环实现了递归的功能
                    lastRe = ((ElementExpression) lastRe).getEles().get(0);
                    if (lastRe instanceof ElementExpression) {
                        // 此时，lastRe还是为b
                        flag = ((ElementExpression) lastRe).getEles().size() > 0;
                    } else if (lastRe instanceof ElementsExpression) {
                        flag = ((ElementsExpression) lastRe).getEles().size() > 0;
                    } else {
                        // 退出
                        flag = false;
                    }

                } else {
                    // 说明lastRe元素下面，没有子元素哦
                    // 退出
                    flag = false;
                }
            } else if (lastRe instanceof ElementsExpression) {
                if (((ElementsExpression) lastRe).getEles().size() > 0) {
                    lastRe = ((ElementsExpression) lastRe).getEles().get(0);

                    if (lastRe instanceof ElementExpression) {
                        // 此时，lastRe还是为b
                        flag = ((ElementsExpression) lastRe).getEles().size() > 0;
                    } else if (lastRe instanceof ElementsExpression) {
                        flag = ((ElementsExpression) lastRe).getEles().size() > 0;
                    } else {
                        // 退出
                        flag = false;
                    }

                } else {
                    flag = false;
                }

            } else {
                flag = false;
            }
        }

        return lastRe;
    }

}
