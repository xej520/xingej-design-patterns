package com.xingej.prototype;

import java.util.Date;

/**
 * 原型模型： 深复制
 * 
 * 所有对象，自己用自己的引用，不在公用了。
 * 
 * @author erjun 2017年11月13日 上午9:15:10
 */
public class Sheep2 implements Cloneable {

    private String name;

    private Date birthday;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 第一，先调用父类的clone方法，实现浅复制
        Object object = super.clone();

        Sheep2 sheep2 = (Sheep2) object;

        // 第二、对 对象里的引用进行 浅复制，并进行属性设置
        sheep2.setBirthday((Date) this.birthday.clone());

        return sheep2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
