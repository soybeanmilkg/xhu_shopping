package com.example.xhushopping.vo;

import lombok.Data;

@Data
public class MessageBean {

    private boolean insert_shopping_msg;
    private boolean delete_shopping_msg;
    private boolean login_in_msg;
    private boolean register_msg;
    private boolean modify_msg;
    private boolean check_username_msg;
    private String pay_msg;  //是否支付
    private boolean delete_order_msg;   //删除订单是否成功
    private String order_msg;   //下单结果信息
}
