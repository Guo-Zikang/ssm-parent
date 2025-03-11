package com.atguigu.spring.ioc.dao;

import com.atguigu.spring.ioc.bean.Dog;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class UserDao {
    Dog haha;

    /**
     * 推荐：构造器注入
     */
    // Spring自动到容器中找到 构造器所需的所有参数的组件值。
/*    public UserDao(Dog dog) {
        System.out.println("UserDao 调用有参构造器： " + dog);
        haha = dog;
    }*/

/*    @Autowired
    public void setDog(@Qualifier("dog01") Dog dog) {
        System.out.println("setDog..." + dog);
        this.haha = dog;
    }*/
}
