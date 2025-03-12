package com.atguigu.springmvc01helloworld.bean;

import lombok.Data;

/**
 * username=张三&password=123456&cellphone=111111&agreement=on
 * &address.province=陕西&address.city=西安&address.area=雁塔&sex=男&hobby=足球&hobby=篮球&hobby=乒乓球&grade=三年级
 */
@Data
public class Person {
    private String username;
    private String password;
    private String cellphone;
    private boolean agreement;
    private Address address;
    private String sex;
    private String[] hobby;
    private String grade;
}

@Data
class Address {
    private String province;
    private String city;
    private String area;
}
