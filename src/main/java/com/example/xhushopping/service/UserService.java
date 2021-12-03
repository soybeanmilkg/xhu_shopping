package com.example.xhushopping.service;

import com.example.xhushopping.entity.User;
import com.example.xhushopping.mapper.UsersMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Resource
    private UsersMapper usersMapper;

    //用户登录
    public String checkUsers(String username, String password) {
        List<User> users = usersMapper.selectAll();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password)) {
                    return "success";
                } else {
                    return "key_password";
                }
            }
        }
        return "key_username";
    }

    //用户注册
    public User register(User user) {
        user.setUserImage("/userImage/default.jpg");
        int flag = usersMapper.insertUser(user);
        //判断插入数据库是否成功
        if (flag > 0) {
            return user;
        } else {
            return null;
        }
    }

    //根据用户名查询用户
    public User selectUser(String username) {
        User user = usersMapper.selectUser(username);
        return user;
    }

    //编辑个人信息
    public int modifyUser(User user, MultipartFile file, HttpSession session) throws IOException {
        //头像修改
        User user1 = (User) session.getAttribute("user");
        //获得物理路径webapp所在路径
        String pathRoot = session.getServletContext().getRealPath("");
        String path = "";
        if (!file.isEmpty()) {
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType = file.getContentType();
            //获得文件后缀名称
            String imageName = contentType.substring(contentType.indexOf("/") + 1);
            path = "/userImage/" + uuid + "." + imageName;
            //判断用户是否修改头像
            if (user1.getUserImage() == null || !user1.getUserImage().equals(path)) {
                if (user1.getUserImage() != null) {
                    //删除原来头像
                    File file1 = new File(pathRoot + user1.getUserImage());
                    if (file1.exists()) {
                        file1.delete();
                    }
                }
                //存入新头像
                file.transferTo(new File(pathRoot + path));
            }
        }
        user1.setUserImage(path);
        //其他信息修改
        user1.setUsername(user.getUsername());
        user1.setUserName(user.getUserName());
        user1.setAddress(user.getAddress());
        user1.setEmail(user.getEmail());
        user1.setPhone(user.getPhone());
        //更新数据库
        usersMapper.updateUser(user1);
        session.setAttribute("user", user1);
        return 0;
    }
}
