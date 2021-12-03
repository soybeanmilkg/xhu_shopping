package com.example.xhushopping.controller;

import com.example.xhushopping.entity.User;
import com.example.xhushopping.service.UserService;
import com.example.xhushopping.vo.MessageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    //接受登录请求
    @RequestMapping("/login.action")
    @ResponseBody
    public MessageBean login(String username, String password,HttpSession session) {
        String flag = userService.checkUsers(username, password);
        User user = userService.selectUser(username);
        session.setAttribute("user",user);
        MessageBean messageBean=new MessageBean();
        if (flag.equals("success")) {
            messageBean.setLogin_in_msg(true);
        } else {
            messageBean.setLogin_in_msg(false);
        }
        return messageBean;
    }

    // 接受注册请求
    @RequestMapping("/register.action")
    @ResponseBody
    public MessageBean register(User user,HttpSession session) {
        MessageBean messageBean=new MessageBean();
        User user1 = userService.register(user);
        if (user1!=null) {
            session.setAttribute("user", user1 );
            messageBean.setRegister_msg(true);
        } else {
            messageBean.setRegister_msg(false);
        }
        return messageBean;
    }

    //编辑个人信息
    @RequestMapping("/modify.action")
    @ResponseBody
    public MessageBean modifyUser(MultipartFile file, HttpSession session, User user) throws IOException {
        userService.modifyUser(user, file, session);
        MessageBean messageBean=new MessageBean();
        messageBean.setModify_msg(true);
        return messageBean;
    }

    //检查用户名是否重复
    @RequestMapping("/checkUsername.action")
    @ResponseBody
    public MessageBean checkUsername(String username) {
        User user = userService.selectUser(username);
        MessageBean messageBean=new MessageBean();
        if (user == null) {
            messageBean.setCheck_username_msg(true);
        } else {
            messageBean.setCheck_username_msg(false);
        }
        return messageBean;
    }
    //返回当前登录用户信息
    @RequestMapping("/returnUser.action")
    @ResponseBody
    public User returnUser(HttpSession session){
        return (User)session.getAttribute("user");
    }

}

