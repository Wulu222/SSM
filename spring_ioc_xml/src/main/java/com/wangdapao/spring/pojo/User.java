package com.wangdapao.spring.pojo;

public class User {
    private String name;
    private Integer age;
    private String sex;
    private String address;

    public User() {
        System.out.println("生命周期一：实例化");
    }

    public User(String name, Integer age, String sex, String address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
        System.out.println("生命周期二：依赖注入");
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void init(){
        System.out.println("生命周期三：初始化");
    }

    public void destroy(){
        System.out.println("生命周期四：销毁");
    }
}
