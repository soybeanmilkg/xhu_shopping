package com.example.xhushopping.mapper;

import com.example.xhushopping.entity.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UsersMapper extends Mapper<User> {
    //查询所有用户
    @Override
    List<User> selectAll();

    //按用户名查找用户
    User selectUser(String username);

    //插入用户
    int insertUser(User user);

    //更新用户数据
    int updateUser(User user);

    //删除用户
    int deleteUser(User user);
}