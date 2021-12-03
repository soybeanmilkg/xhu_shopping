package com.example.xhushopping.controller;

import com.example.xhushopping.entity.Shopping;
import com.example.xhushopping.entity.User;
import com.example.xhushopping.service.ShoppingService;
import com.example.xhushopping.vo.MessageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 购物操作
 *
 * @author soybeanmilk
 * @date
 */
@Controller
public class ShoppingController {
    @Resource
    private ShoppingService shoppingService;

    //接受下单请求
    @RequestMapping("/order.action")
    @ResponseBody
    public MessageBean order(HttpSession session, Shopping shopping) {
        //获取session域中的user对象
        User user = (User) session.getAttribute("user");
        //处理下单业务
        int st = shoppingService.order(user, shopping);
        MessageBean messageBean = new MessageBean();
        String msg = "";
        //判断业务处理结果
        if (st == 0) {
            //下单成功
            msg = "下单成功";
        } else if (st == 1) {
            //库存不足
            msg = "库存不足";
        } else if (st == 2) {
            //用户未填写地址
            msg = "用户未填写地址";
        } else if (st == -1) {
            //数据库出错
            msg = "服务器维护中";
        }
        messageBean.setOrder_msg(msg);
        return messageBean;
    }

    //展示全部商品
    @RequestMapping("/queryAllShoppings.action")
    @ResponseBody
    public List<Shopping> query_All_Shopping() {
        return shoppingService.showShopping();
    }

    //增加商品信息
    @RequestMapping("/insertShoppings")
    public MessageBean insertShoppings(Shopping shopping) {
        int flag = shoppingService.insertShopping(shopping);
        MessageBean messageBean=new MessageBean();
        if (flag == 0) {
            messageBean.setInsert_shopping_msg(false);
        } else {
            messageBean.setInsert_shopping_msg(true);
        }
        return messageBean;
    }

    //下架商品
    @RequestMapping("/deleteShoppings")
    public MessageBean deleteShoppings(Shopping shopping) {
        MessageBean messageBean=new MessageBean();
        int flag = shoppingService.addShopping(shopping);
        if (flag == 0) {
            messageBean.setDelete_shopping_msg(false);
        } else {
            messageBean.setDelete_shopping_msg(true);
        }
        return messageBean;
    }
}
