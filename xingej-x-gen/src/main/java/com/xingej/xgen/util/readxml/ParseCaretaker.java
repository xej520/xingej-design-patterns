package com.xingej.xgen.util.readxml;

public class ParseCaretaker {
    // 保存 原对象
    private ParseMemento memento;

    private static ParseCaretaker INSTANCE = new ParseCaretaker();

    private ParseCaretaker() {

    }

    public static ParseCaretaker getInstance() {
        return INSTANCE;
    }

    // 保存
    public void saveMemento(ParseMemento memento) {
        this.memento = memento;
    }

    // 获取
    public ParseMemento retriveMemento() {
        return this.memento;
    }

}
