package com.example.xhushopping.service;

import com.example.xhushopping.entity.Orderform;
import com.example.xhushopping.entity.Shopping;
import com.example.xhushopping.mapper.OrderformMapper;
import com.example.xhushopping.mapper.ShoppingMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class OrderformService {
    @Resource
    private OrderformMapper orderformMapper;
    @Resource
    private ShoppingMapper shoppingMapper;

    //查看所有订单
    public List<Orderform> queryOrderform(String username) {
        List<Orderform> orderforms = orderformMapper.select_user_orderform(username);
        return orderforms;
    }

    //根据订单号查看订单信息
    public boolean selectOrderform(Long OrderformNum,String flag,HttpSession session){

        Orderform orderform=orderformMapper.selectOrderform(OrderformNum);
        if("yes".equals(flag)){
            orderform.setIspayoff("是");
            orderformMapper.updateOrderform(orderform);
            return true;
        }

        session.setAttribute("orderform",orderform);
        return false;
    }

    //删除订单信息
    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            rollbackFor = {
                    NullPointerException.class,
                    RuntimeException.class
            }
    )
    public boolean deleteOrderform(Long orderformnum){
        //根据订单名查找订单类
        Orderform orderform = orderformMapper.selectOrderform(orderformnum);
        //通过订单类中的商品名获得商品类
        Shopping shopping=shoppingMapper.selectShopping(orderform.getOderShoppingName());
        double price=orderform.getPrice();
        double shopping_price=shopping.getShoppingprice();
        int number=(int)(price/shopping_price);
        int flag=orderformMapper.deleteOrderform(orderform);
        if(flag==1){
            shopping.setAmount(number);
            shoppingMapper.updateShopping(shopping);
            return true;
        }
        return false;
    }
}
