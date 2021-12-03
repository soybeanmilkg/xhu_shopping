package com.example.xhushopping.controller;

import com.example.xhushopping.entity.Orderform;
import com.example.xhushopping.service.OrderformService;
import com.example.xhushopping.vo.MessageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderformController {
    @Resource
    private OrderformService orderformService;

    //查看订单
    @RequestMapping("/queryOrder.action")
    @ResponseBody
    public List<Orderform> queryOrder(String username) {
        return orderformService.queryOrderform(username);
    }

    //是否支付
    @RequestMapping("/IfpayOff.action")
    @ResponseBody
    public MessageBean IfpayOff(Long OrderformNum, String flag, HttpSession session) {
        MessageBean messageBean = new MessageBean();
        boolean sign = orderformService.selectOrderform(OrderformNum, flag, session);
        if (sign) {
            messageBean.setPay_msg("支付成功");
        } else {
            messageBean.setPay_msg("支付失败");
        }
        return messageBean;
    }

    //删除订单
    @RequestMapping("/deldeteOrder.action")
    @ResponseBody
    public MessageBean deleteOrder(Long orderformnum) {
        boolean flag = orderformService.deleteOrderform(orderformnum);
        MessageBean messageBean = new MessageBean();
        messageBean.setDelete_order_msg(flag);
        return messageBean;
    }
}
