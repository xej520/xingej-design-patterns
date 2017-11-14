package com.xingej.patterns.prototype.example2;

import java.io.Serializable;
import java.util.Date;

/**
 * 测试，使用序列化和反序列化的方式来实现 深复制，或者说 深克隆
 * 
 * @author erjun 2017年11月14日 上午8:55:46
 */
public class Cat implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private Date birthday;

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

    @Override
    public String toString() {
        return "Cat [name=" + name + ", birthday=" + birthday + "]";
    }

}
