package com.example.xhushopping.entity;

import javax.persistence.*;

public class Orderform {
    @Id
    @Column(name = "orderFormID")
    private Integer orderformid;

    @Column(name = "submitTime")
    private String submittime;

    @Column(name = "consignmentTime")
    private String consignmenttime;

    private double price;

    @Column(name = "isPayoff")
    private String ispayoff;

    @Column(name = "isConsignment")
    private String isconsignment;

    private String username;

    @Column(name = "orderFormNum")
    private Long orderformnum;

    private String oderShoppingName;

    /**
     * @return orderFormID
     */
    public Integer getOrderformid() {
        return orderformid;
    }

    /**
     * @param orderformid
     */
    public void setOrderformid(Integer orderformid) {
        this.orderformid = orderformid;
    }

    /**
     * @return submitTime
     */
    public String getSubmittime() {
        return submittime;
    }

    /**
     * @param submittime
     */
    public void setSubmittime(String submittime) {
        this.submittime = submittime;
    }

    /**
     * @return consignmentTime
     */
    public String getConsignmenttime() {
        return consignmenttime;
    }

    /**
     * @param consignmenttime
     */
    public void setConsignmenttime(String consignmenttime) {
        this.consignmenttime = consignmenttime;
    }

    /**
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return isPayoff
     */
    public String getIspayoff() {
        return ispayoff;
    }

    /**
     * @param ispayoff
     */
    public void setIspayoff(String ispayoff) {
        this.ispayoff = ispayoff;
    }

    /**
     * @return isConsignment
     */
    public String getIsconsignment() {
        return isconsignment;
    }

    /**
     * @param isconsignment
     */
    public void setIsconsignment(String isconsignment) {
        this.isconsignment = isconsignment;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return orderFormNum
     */
    public Long getOrderformnum() {
        return orderformnum;
    }

    /**
     * @param orderformnum
     */
    public void setOrderformnum(Long orderformnum) {
        this.orderformnum = orderformnum;
    }

    public String getOderShoppingName() {
        return oderShoppingName;
    }

    public void setOderShoppingName(String oderShoppingName) {
        this.oderShoppingName = oderShoppingName;
    }
}