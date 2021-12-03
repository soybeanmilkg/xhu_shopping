package com.example.xhushopping.mapper;

import com.example.xhushopping.entity.Shopping;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ShoppingMapper extends Mapper<Shopping> {
    //查询所有商品
    @Override
    List<Shopping> selectAll();

    //按商品名查找商品
    Shopping selectShopping(String shoppingName);

    //插入商品
    int insertShopping(Shopping Shopping);

    //更新商品数据
    int updateShopping(Shopping Shopping);

    //删除商品
    int deleteShopping(Shopping Shopping);
}