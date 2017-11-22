package com.xingej.patterns.behaviorPattern.memento;

/**
 * 备份对象
 * 
 * 备份的是Emp对象
 * 
 * @author erjun 2017年11月22日 下午7:15:40
 */
public class EmpMemento {
    private String ename;

    private int age;

    private double salary;

    // 创建对象时，就是备份的过程
    public EmpMemento(Emp emp) {
        this.ename = emp.getEname();

        this.age = emp.getAge();

        this.salary = emp.getSalary();
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

}
