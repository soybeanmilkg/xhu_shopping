package com.example.xhushopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageJumpController {
    //跳转登录页面
    @RequestMapping("/tologin.action")
    public String toLogin(){
        return "login";
    }

    //跳转主页
    @RequestMapping("/toindex.action")
    public String toIndex(){
        return "index";
    }

    //跳转线下市场页
    @RequestMapping("/toshopping.action")
    public String toOfflineMarket(){
        return "shopping";
    }
}
