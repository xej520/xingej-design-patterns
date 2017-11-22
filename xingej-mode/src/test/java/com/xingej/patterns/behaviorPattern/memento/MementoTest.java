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

    // 额的天啊，第一次感觉，原来栈有这么的作用
    // 可以做历史记录的恢复

    // GitHub的版本恢复，底层不知道是不是这个 备忘录模式呢？

    // 恢复多次历史记录
    @Test
    public void testStack() {
        // 创建 原对象
        Emp emp = new Emp("xingej", 22, 1111);

        System.out.println("---原对象--0-:\t" + emp.toString());

        // 创建一个 高级的备份对象管理者
        HighCareTaker highCareTaker = new HighCareTaker();
        // 创建第一个备份对象
        EmpMemento empMemento1 = new EmpMemento(emp);
        // 将第一个备份对象，交给 高级管理者进行管理
        highCareTaker.push(empMemento1);

        // 对 原对象，进行第一次更新
        emp.setEname("beijing");
        emp.setAge(10);
        emp.setSalary(99999);
        System.out.println("---原对象--1-:\t" + emp.toString());
        // 开始第二次备份
        EmpMemento empMemento2 = new EmpMemento(emp);
        // 交给 高级管理者
        highCareTaker.push(empMemento2);

        // 再次更新 原对象
        emp.setEname("hangzhou");
        emp.setAge(33);
        emp.setSalary(88888);
        System.out.println("---原对象--2-:\t" + emp.toString());
        // 开始第二次备份
        EmpMemento empMemento3 = new EmpMemento(emp);
        // 交给 高级管理者
        highCareTaker.push(empMemento3);

        System.out.println("-----开始恢复历史记录了----先从最近的更新恢复--------");

        // 恢复3次
        for (int i = 0; i < 3; i++) {
            emp.recovery(highCareTaker.pop());
            System.out.println(emp);
        }

    }

}
