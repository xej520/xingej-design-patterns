package com.xingej.patterns.behaviorPattern.memento;

import java.util.Stack;

/**
 * 对备份对象管理者进行了升级
 * 
 * 可以设置多个备份点
 * 
 * 也就是说，可以恢复多次历史记录
 * 
 * @author erjun 2017年11月22日 下午7:45:30
 */
public class HighCareTaker {
    private Stack<EmpMemento> stack = new Stack<>();

    // 入栈，就是往容器里，添加一次历史记录
    public void push(EmpMemento empMemento) {
        stack.push(empMemento);
    }

    // 出栈，就是从容器里，取出最近的依次历史记录
    public EmpMemento pop() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.pop();
    }

}
