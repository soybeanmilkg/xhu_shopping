package com.example.xhushopping.service;

import com.example.xhushopping.entity.Orderform;
import com.example.xhushopping.entity.User;
import com.example.xhushopping.mapper.OrderformMapper;
import com.example.xhushopping.mapper.ShoppingMapper;
import com.example.xhushopping.mapper.UsersMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class TestService {
    @Resource
    private OrderformMapper orderformMapper;
    @Resource
    private ShoppingMapper shoppingMapper;
    @Resource
    private UsersMapper usersMapper;
    @Resource
    public OrderformService orderformService;
    @Resource
    public ShoppingService shoppingService;
    @Resource
    public UserService userService;

    //测试
    public User test1(String username) {
        User user = usersMapper.selectUser(username);
        return user;
    }

    //测试
    public Orderform test2(Long orderformNum) {
        Orderform or = orderformMapper.selectOrderform(orderformNum);
        return or;
    }

    //测试三：图片上传
    public void test3(String username, MultipartFile file, HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        User user = usersMapper.selectUser(username);
        //获得物理路径webapp所在路径
        String pathRoot = req.getSession().getServletContext().getRealPath("");
        String path = "";
        if (!file.isEmpty()) {
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType = file.getContentType();
            //获得文件后缀名称
            String imageName = contentType.substring(contentType.indexOf("/") + 1);
            path = "/userImage/" + uuid + "." + imageName;
            file.transferTo(new File(pathRoot + path));
        }
        System.out.println(path);
        user.setUserImage(path);
        req.setAttribute("user", user);
        usersMapper.updateUser(user);
        req.getRequestDispatcher("WEB-INF/views/show.jsp").forward(req, res);
    }

}
