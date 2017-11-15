package com.xingej.patterns.prototype;

import java.util.Date;

/**
 * 测试 原型模式
 * 
 * 这里是 浅复制哦
 * 
 * 实现克隆的话，必须
 * 
 * 1、在被克隆的对象上，必须实现Cloneable接口
 * 
 * 2、重写Object里的clone方法，
 * 
 * @author erjun 2017年11月13日 上午8:40:05
 */
public class Sheep implements Cloneable {
    private String name;

    private Date birthday;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 调用父类Object的方法，就可以了
        return super.clone();
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
