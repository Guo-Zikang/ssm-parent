package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.bean.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    //按照id查询客户以及客户的订单信息
    Customer getCustomerByIdWithOrders(Long id);
}
