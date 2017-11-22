package com.xingej.patterns.behaviorPattern.memento;

/**
 * 备忘录模式
 * 
 * 核心：就是保存某个对象内部状态的拷贝，这样以后，就可以将该对象恢复到原先的状态
 * 
 * 结构:
 * 
 * 原对象、备份对象、管理备份对象的类
 * 
 * 其实，就两个操作，一个是对原对象，进行备份； 一个是，对原对象进行恢复
 * 
 * 1、先创建 原对象 2、创建管理者 3、创建备份对象 4、将备份对象交给管理者进行存储 5、更新原对象 6、从管理者那里取出原对象 7、开始恢复原对象
 * 
 * @author erjun 2017年11月22日 下午7:12:59
 */
// 原对象
public class Emp {

    private String ename;

    private int age;

    private double salary;

    public Emp(String ename, int age, double salary) {
        this.ename = ename;
        this.age = age;
        this.salary = salary;
        // 当然，也可以在这里添加，对当前对象，进行备份;
        // 也就是 实现 自动备份，只要创建对象，就备份一份
        // memento();
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emp [ename=" + ename + ", age=" + age + ", salary=" + salary + "]";
    }

    // -----------备忘录模式----特有方法------
    // 进行备忘操作，并返回备忘录对象
    public EmpMemento memento() {
        return new EmpMemento(this);
    }

    // 进行数据恢复，恢复成指定备忘录对象的值
    public void recovery(EmpMemento empMemento) {
        this.ename = empMemento.getEname();
        this.age = empMemento.getAge();
        this.salary = empMemento.getSalary();
    }

}
