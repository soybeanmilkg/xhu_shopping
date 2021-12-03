package com.example.xhushopping.mapper;

import com.example.xhushopping.entity.Ordernum;

public interface OrdernumMapper {
    //查询最近一天的订单量
    Ordernum selectRecent();
    //查询某一天的订单量
    Ordernum selectOrdernum(String ordernum_time);
    //插入某天订单量
    int insertOrdernum(Ordernum ordernum);
    //更新订单量
    int updateOrdernum(Ordernum ordernum);
    //删除某天订单量
    int deleteOrdernum(Ordernum ordernum);
}
