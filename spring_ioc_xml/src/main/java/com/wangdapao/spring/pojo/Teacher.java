package com.wangdapao.spring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private String teacherName;
    private Map<Integer,Student> students;
}
