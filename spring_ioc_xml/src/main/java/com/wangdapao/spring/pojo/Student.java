package com.wangdapao.spring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements People{
    private String name;
    private int age;
    private String sex;
    private String address;
    private String phone;
    private String[] hobbies;
    private Clazz clazz;


    public Student(String name, int age, String sex, String address, String phone) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.phone = phone;

    }
}
