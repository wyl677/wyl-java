package com.wyl.converter;

import java.io.Serializable;
import java.util.Date;

/**
 * @auther yanl.wang
 * @date 2023/2/7
 **/
public class Student implements Serializable {
    private String id;
    private Date birthday;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
