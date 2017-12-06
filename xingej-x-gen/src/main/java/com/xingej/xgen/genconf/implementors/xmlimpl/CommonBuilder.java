package com.xingej.xgen.genconf.implementors.xmlimpl;

import com.xingej.xgen.genconf.constants.ExpressionEnum;
import com.xingej.xgen.genconf.constants.GenConfEnum;

/**
 * 将抽象部分，提炼出来
 * 
 * @author erjun 2017年12月7日 上午6:36:58
 * @param <T>
 *            泛型，
 */
public abstract class CommonBuilder<T> {

    // 用来获取分步骤，拼接的字符串，也就是最终的产品
    protected abstract StringBuffer getBuilderBuffer();

    // 获取实际的构建器对象，不然不知道到底是哪个子类在实现
    // 很明显，需要子类去实现，返回的是当前类class

    // ----->注意，上面说错了，并不是"返回当前类class"
    // 而是，返回子类对象，并不是class类型哦
    protected abstract T getBuilderClassInstance();

    // 拼接"."
    public T addDot() {
        getBuilderBuffer().append(ExpressionEnum.dot.getExpr());

        // ----------------->泛型 不能直接返回T

        // return T;

        return getBuilderClassInstance();
    }

    // 拼接"/"
    public T addSeparator() {
        getBuilderBuffer().append(ExpressionEnum.separator.getExpr());
        return getBuilderClassInstance();
    }

    // 拼接"$"
    public T addDollar() {
        getBuilderBuffer().append(ExpressionEnum.dollar.getExpr());
        return getBuilderClassInstance();
    }

    // 拼接"["
    public T addOpenBracket() {
        getBuilderBuffer().append(ExpressionEnum.openBracket.getExpr());
        return getBuilderClassInstance();
    }

    // 拼接"]"
    public T addCloseBracket() {
        getBuilderBuffer().append(ExpressionEnum.closeBracket.getExpr());
        return getBuilderClassInstance();
    }

    // 拼接"="
    public T addEqual() {
        getBuilderBuffer().append(ExpressionEnum.equal.getExpr());
        return getBuilderClassInstance();
    }

    // 拼接","
    public T addComma() {
        getBuilderBuffer().append(ExpressionEnum.comma.getExpr());
        return getBuilderClassInstance();
    }

    // 拼接"xml"
    public T addXml() {
        getBuilderBuffer().append(ExpressionEnum.xml.getExpr());
        return getBuilderClassInstance();
    }

    // 拼接"xmlFilePre"
    public T addXmlFilePre() {
        getBuilderBuffer().append(ExpressionEnum.xmlFilePre.getExpr());
        return getBuilderClassInstance();
    }

    // ----------下面拼接公共的属性，如id,name,--------
    // 拼接"id"
    public T addId() {
        getBuilderBuffer().append(GenConfEnum.id);
        return getBuilderClassInstance();
    }

    // 拼接 传入的值, 也就是说，你传入的是什么，我就拼接什么
    public T addOtherValue(String value) {
        getBuilderBuffer().append(value);
        return getBuilderClassInstance();
    }

    // 返回产品的方法
    public String build() {
        // 调用子类的方法
        return getBuilderBuffer().toString();
    }

}
