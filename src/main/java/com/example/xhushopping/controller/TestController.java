package com.example.xhushopping.controller;

import com.example.xhushopping.entity.Orderform;
import com.example.xhushopping.entity.User;
import com.example.xhushopping.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class TestController {
    @Resource
    private TestService test;
    //测试一:按用户名查找用户
    @RequestMapping("/test1.action")
    public ModelAndView test1(String username) {
        ModelAndView mv = new ModelAndView();
        User user = test.test1(username);
        mv.addObject("user", user);
        mv.setViewName("WEB-INF/views/show.jsp");
        return mv;
    }

    //测试二：按订单号查找订单
    @RequestMapping("/test2.action")
    public ModelAndView test2(Long orderformNum) {
        ModelAndView mv = new ModelAndView();
        Orderform orderform = test.test2(orderformNum);
        mv.addObject("orderform", orderform);
        mv.setViewName("WEB-INF/views/show.jsp");
        return mv;
    }

    //测试三：图片上传
    @RequestMapping("/test3.action")
    public ModelAndView test3(MultipartFile userImage, String username, HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        ModelAndView mv = new ModelAndView();
        test.test3(username, userImage, req, res);
        return mv;
    }

}
