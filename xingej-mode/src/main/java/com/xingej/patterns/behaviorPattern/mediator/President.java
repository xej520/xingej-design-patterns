package com.xingej.patterns.behaviorPattern.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * 具体的中介者
 * 
 * @author erjun 2017年11月21日 下午2:13:42
 */
public class President implements Mediator {

    private Map<String, Department> map = new HashMap<>();

    @Override
    public void register(String name, Department department) {
        map.put(name, department);
    }

    // 这里，可以实现AOP，调用之前，之后，可以添加一些操作的，统一处理的
    // 有点类似于反射里的invoke()
    @Override
    public void command(String name) {
        // 中介者 ，直接调用其他组件
        map.get(name).selfAction();
    }

}
