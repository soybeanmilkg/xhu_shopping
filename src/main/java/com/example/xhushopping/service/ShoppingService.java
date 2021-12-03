package com.example.xhushopping.service;

import com.example.xhushopping.entity.Orderform;
import com.example.xhushopping.entity.Ordernum;
import com.example.xhushopping.entity.Shopping;
import com.example.xhushopping.entity.User;
import com.example.xhushopping.mapper.OrderformMapper;
import com.example.xhushopping.mapper.OrdernumMapper;
import com.example.xhushopping.mapper.ShoppingMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ShoppingService {
    @Resource
    private OrderformMapper orderformMapper;
    @Resource
    private ShoppingMapper shoppingMapper;
    @Resource
    private OrdernumMapper ordernumMapper;

    //下单
    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            rollbackFor = {
                    NullPointerException.class,
                    RuntimeException.class
            }
    )
    public int order(User user, Shopping shopping1) {
        Shopping shopping2 = shoppingMapper.selectShopping(shopping1.getShoppingName());
        //判断库存是否充足
        if (shopping1.getAmount() > shopping2.getAmount()) {
            return 1;
        }
        //判断用户是否填写地址
        if (user.getAddress() == null) {
            return 2;
        }
        //生成订单号
        Orderform orderform1 = orderformMapper.selectRecentOrderform();
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        long nums = orderform1.getOrderformnum() % 10000;
        long time = orderform1.getOrderformnum() / 10000;
        long orderNo = Long.parseLong((date)) * 10000;
        Ordernum ordernum = new Ordernum();
        ordernum.setOrdernum_time(Long.toString(time));
        if (time > Long.parseLong((date))) {
            nums = 1L;
        } else {
            nums++;
        }
        ordernum.setOrdernum_num((int) nums);
        if (ordernumMapper.selectOrdernum(Long.toString(time)) == null) {
            ordernumMapper.insertOrdernum(ordernum);
        } else {
            ordernumMapper.updateOrdernum(ordernum);
        }
        orderNo += nums;
        //封装订单
        Orderform orderform = new Orderform();
        orderform.setSubmittime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        orderform.setConsignmenttime("");
        orderform.setPrice(shopping1.getAmount() * shopping2.getShoppingprice());
        orderform.setIspayoff("否");
        orderform.setIsconsignment("否");
        orderform.setOderShoppingName(shopping1.getShoppingName());
        orderform.setUsername(user.getUsername());
        orderform.setOrderformnum(orderNo);
        //将订单插入数据库
        int num1 = orderformMapper.insertOrderform(orderform);
        //判断订单是否插入成功
        if (num1 < 0) {
            return -1;
        }
        int i = 1/0;
        //修改商品库存
        shopping2.setAmount(shopping2.getAmount() - shopping1.getAmount());
        int num2 = shoppingMapper.updateShopping(shopping2);
        //判断商品库存是否修改成功
        if (num2 < 0) {
            return -1;
        }
        return 0;
    }

    //查看全部商品信息
    public List<Shopping> showShopping() {
        List<Shopping> show = shoppingMapper.selectAll();
        return show;
    }

    //增加商品信息
    public int insertShopping(Shopping shopping) {
        int flag = shoppingMapper.insertShopping(shopping);
        return flag;
    }

    //上架商品
    public int addShopping(Shopping shopping) {
        int flag = shoppingMapper.insertShopping(shopping);
        return flag;
    }
}
