package com.xingej.patterns.behaviorPattern.memento;

import org.junit.Test;

/**
 * 备忘录模式 测试
 * 
 * @author erjun 2017年11月22日 下午7:27:51
 */
public class MementoTest {

    @Test
    public void test() {
        // 创建 原对象
        Emp emp = new Emp("xingej", 22, 1111);

        System.out.println("---原对象---:\t" + emp.toString());

        // 创建一个 管理 备份对象的人
        CareTaker careTaker = new CareTaker();

        // 第二步：对原对象进行备份
        // 2.1 先创建一个 备份对象
        EmpMemento memento = emp.memento();
        // 2.2 将 备份对象，交给 管理者进行管理
        careTaker.setMemento(memento);

        // 更新原对象的属性
        emp.setAge(19);
        emp.setEname("spark");
        emp.setSalary(222);
        System.out.println("---更新后的原对象----:\t" + emp.toString());

        // 第三步：恢复原对象
        // 3.1 先取出备份对象
        EmpMemento memento2 = careTaker.getMemento();
        // 3.2 开始进行恢复
        emp.recovery(memento2);

        System.out.println("---恢复后的原对象----:\t" + emp.toString());

    }

}
