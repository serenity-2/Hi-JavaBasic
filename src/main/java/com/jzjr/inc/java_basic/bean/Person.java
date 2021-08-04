package com.jzjr.inc.java_basic.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    public String name;
    private int salary;
    public int age;
   private String sex;
   private String city;
//    // 定义静态字段number:
//    public static int number;
}
