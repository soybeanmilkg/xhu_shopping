package com.example.xhushopping.service;

import com.example.xhushopping.entity.Ordernum;
import com.example.xhushopping.mapper.OrdernumMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdernumService {
    @Resource
    private OrdernumMapper ordernumMapper;

    //返回最近一周的数据
    public List<Ordernum> queryRecent(HttpSession session) {
        List<Ordernum> ordernums = new ArrayList<>();
        Ordernum ordernum = ordernumMapper.selectRecent();
        long time = Long.parseLong(ordernum.getOrdernum_time());
        for (int i = 0; i < 7; i++) {
            ordernums.add(ordernum);
            time--;
            ordernum = ordernumMapper.selectOrdernum(Long.toString(time));
            if (ordernum == null) {
                break;
            }
        }
        return ordernums;
    }

}
