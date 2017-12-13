package com.xingej.xgen.genconf.constants;

/**
 * 枚举例子
 * 
 * @author erjun 2017年12月7日 上午5:47:30
 */
public enum ExpressionEnum {
    // dot，separator。。。。。就是当前枚举类ExpressionEnum的实例对象名称
    // ".","/" 是传入的参数
    dot("."), separator("/"), dollar("$"), openBracket("["), closeBracket("]"), equal("="), comma(",")

    // xml 这个是文件名后缀
    , xml("xml")

    // 这个是前缀
    , xmlFilePre("/cn/javass/xgenconfxml/")

    , themeXmlName("ThemeConf.xml"),

    location("Location"),

    fileName("fileName");

    private String expr;

    private ExpressionEnum(String expr) {
        this.expr = expr;
    }

    public String getExpr() {
        return this.expr;
    }
}
