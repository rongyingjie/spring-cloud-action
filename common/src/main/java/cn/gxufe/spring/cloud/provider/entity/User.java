package cn.gxufe.spring.cloud.provider.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user")
public class User {

    public User(){}

    public User(String id, Integer age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Id
    private String id;
    @Column
    private Integer age;
    @Column
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}