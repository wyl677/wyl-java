package com.wyl.beanpost;

/**
 * @auther yanl.wang
 * @date 2023/2/8
 **/
public class Categroy {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Categroy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
