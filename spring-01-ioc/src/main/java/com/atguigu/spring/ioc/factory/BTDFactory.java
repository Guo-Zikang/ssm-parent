package com.atguigu.spring.ioc.factory;

import com.atguigu.spring.ioc.bean.Car;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class BTDFactory implements FactoryBean<Car> {
    /**
     * 调用此方法制造对象。
     * @return
     */
    @Override
    public Car getObject() {
        System.out.println("BYDFactory正在制造Car对象。");
        return new Car();
    }

    /**
     * 说明造的东西的类型。
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    /**
     * 是单例吗？
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
