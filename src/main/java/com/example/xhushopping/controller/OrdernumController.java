package com.example.xhushopping.controller;

import com.example.xhushopping.entity.Ordernum;
import com.example.xhushopping.service.OrdernumService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrdernumController {
    @Resource
    private OrdernumService ordernumService;

    //查询最近七天的订单量
    @RequestMapping("/ordernums.action")
    @ResponseBody
    public List<Ordernum> queryRecent(HttpSession session){
        return ordernumService.queryRecent(session);
    }
}
