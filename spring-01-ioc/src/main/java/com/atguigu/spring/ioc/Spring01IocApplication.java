package com.atguigu.spring.ioc;

import com.atguigu.spring.ioc.bean.*;
import com.atguigu.spring.ioc.controller.UserController;
import com.atguigu.spring.ioc.dao.DeliveryDao;
import com.atguigu.spring.ioc.dao.UserDao;
import com.atguigu.spring.ioc.service.HahaService;
import com.atguigu.spring.ioc.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * 主入口类，称为主程序类
 */
@SpringBootApplication
public class Spring01IocApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("==============容器创建完成==============");

        Car2 car = ioc.getBean(Car2.class);
        System.out.println(car);
    }

    public static void test12(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("==============容器创建完成==============");

        User bean = ioc.getBean(User.class);
        System.out.println("运行：" + bean);
    }

    public static void test11(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("==============容器创建完成==============");

        DeliveryDao dao = ioc.getBean(DeliveryDao.class);

        dao.saveDelivery();
    }

    public static void test10(String[] args) throws IOException {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("==============容器创建完成==============");

        Dog dog = ioc.getBean(Dog.class);
        System.out.println(dog);

        File file = ResourceUtils.getFile("classpath:img.png");
        System.out.println(file);

        int available = new FileInputStream(file).available();
        System.out.println(available);
    }

    public static void test9(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("==============容器创建完成==============");

        HahaService service = ioc.getBean(HahaService.class);
        System.out.println(service);

        String osType = service.getOsType();
        System.out.println(osType);

        String name = service.getName();
        System.out.println(name);
    }

    public static void test8(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("==============容器创建完成==============");

        UserDao userDao = ioc.getBean(UserDao.class);
        System.out.println(userDao);
    }

    public static void test7(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("==============容器创建完成==============");

        UserService bean = ioc.getBean(UserService.class);
        System.out.println(bean);
    }

    public static void test6(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("==============容器创建完成==============");

        UserController userController = ioc.getBean(UserController.class);
        System.out.println(userController);
    }

    public static void test5(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        Map<String, Person> Beans = ioc.getBeansOfType(Person.class);
        System.out.println("Beans = " + Beans);

        ConfigurableEnvironment environment = ioc.getEnvironment();
        String os = environment.getProperty("OS");
        System.out.println("properties = " + os);
    }

    public static void test4(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("==============容器创建完成==============");

        Dog dog = ioc.getBean("dog", Dog.class);
        System.out.println(dog);

        Car car = ioc.getBean(Car.class);
        System.out.println(car);

        Map<String, Car> beansOfType = ioc.getBeansOfType(Car.class);
        System.out.println(beansOfType);
    }

    public static void test3(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("==============容器创建完成==============");

        Dog dog = ioc.getBean("dog", Dog.class);
        System.out.println(dog);

        Dog dog2 = ioc.getBean("dog", Dog.class);
        System.out.println(dog2);
    }

    public static void test2(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("============");

        UserController userController = ioc.getBean(UserController.class);
        System.out.println(userController);

        UserDao userDao = ioc.getBean(UserDao.class);
        System.out.println(userDao);
    }

    public static void test1(String[] args) {
        //1. 跑起一个Spring的应用； ApplicationContext: Spring应用上下文对象； Ioc容器
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("ioc = " + ioc);

        //2. 获取容器中所有组件的名字，Spring启动有许多默认组件
        String[] names = ioc.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("=========");

        //4. 获取容器中的组件对象：精确获取某个组件
        //4.1 按照名字获取
        Person person = (Person) ioc.getBean("zhangsan");
        System.out.println(person);

        //4.2 按照类型获取
//        Person person1 = (Person) ioc.getBean(Person.class);
//        System.out.println(person1);

        //4.3 按照类型获取所有对象
        Map<String, Person> map = ioc.getBeansOfType(Person.class);
        System.out.println(map);

        //4.4 按照名字和类型获取
        Person bean = ioc.getBean("zhangsan", Person.class);
        System.out.println(bean);

        Object dog = ioc.getBean("dog");
        System.out.println(dog);
    }

    //3. 给容器注册一个自己的组件，方法名为组件名

}
