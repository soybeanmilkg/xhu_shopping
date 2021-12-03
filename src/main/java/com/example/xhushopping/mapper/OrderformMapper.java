package com.example.xhushopping.mapper;

import com.example.xhushopping.entity.Orderform;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface OrderformMapper extends Mapper<Orderform> {

    //查找所有订单
    @Override
    List<Orderform> selectAll();

    //按订单号查找订单
    Orderform selectOrderform(Long OrderformNum);

    //插入订单
    int insertOrderform(Orderform orderform);

    //更新订单数据
    int updateOrderform(Orderform  orderform);

    //删除订单
    int deleteOrderform(Orderform orderform);

    //按用户名查找用户所有订单
    List<Orderform>select_user_orderform(String username);

    //查询id最大的订单
    Orderform selectRecentOrderform();

}