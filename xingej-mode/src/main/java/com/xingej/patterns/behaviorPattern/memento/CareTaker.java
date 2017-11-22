package com.xingej.patterns.behaviorPattern.memento;

/**
 * 负责人类
 * 
 * 负责管理备份对象的
 * 
 * @author erjun 2017年11月22日 下午7:29:06
 */
public class CareTaker {

    private EmpMemento memento;

    public EmpMemento getMemento() {
        return memento;
    }

    public void setMemento(EmpMemento memento) {
        this.memento = memento;
    }

}
