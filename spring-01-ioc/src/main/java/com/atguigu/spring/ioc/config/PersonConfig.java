package com.atguigu.spring.ioc.config;

import com.atguigu.spring.ioc.bean.Person;
import com.atguigu.spring.ioc.condition.MacCondition;
import com.atguigu.spring.ioc.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PersonConfig {

    // 判断电脑的操作系统是Windows还是Mac，是Windows的话容器中放bill，是Mac的话容器中放jobs

    @Conditional(WindowsCondition.class)
    @Bean("bill")
    public Person bill() {
        Person person = new Person();
        person.setName("bill");
        person.setAge(20);
        person.setGender("男");
        return person;
    }

    @Conditional(MacCondition.class)
    @Bean("jobs")
    public Person jobs() {
        Person person = new Person();
        person.setName("jobs");
        person.setAge(20);
        person.setGender("男");
        return person;
    }

    @Primary
    @Bean("zhangsan")
    public Person zhangsan() {
        Person person = new Person();
        person.setName("张三");
        person.setAge(20);
        person.setGender("男");
        return person;
    }

    @Bean("LiSi")
    public Person LiSi() {
        Person person = new Person();
        person.setName("李四");
        person.setAge(20);
        person.setGender("男");
        return person;
    }
}
