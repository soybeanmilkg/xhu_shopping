package com.example.xhushopping.entity;

import javax.persistence.*;

public class Shopping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    @Column(name = "shopping_id")
    private Integer id;

    @Column(name = "shopping_message")
    private String message;

    @Column(name = "shopping_price")
    private Double shoppingprice;

    @Column(name = "shopping_amount")
    private Integer amount;

    @Column(name = "shopping_image")
    private String shoppingImage;

    @Column(name = "shopping_name")
    private String shoppingName;

    @Column(name = "shopping_class")
    private String shoppingClass;

    @Column(name = "shopping_contact")
    private String shoppingContact;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return shoppingprice
     */
    public Double getShoppingprice() {
        return shoppingprice;
    }

    /**
     * @param shoppingprice
     */
    public void setShoppingprice(Double shoppingprice) {
        this.shoppingprice = shoppingprice;
    }

    /**
     * @return amount
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * @param amount
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * @return shopping_image
     */
    public String getShoppingImage() {
        return shoppingImage;
    }

    /**
     * @param shoppingImage
     */
    public void setShoppingImage(String shoppingImage) {
        this.shoppingImage = shoppingImage;
    }

    /**
     * @return shopping_name
     */
    public String getShoppingName() {
        return shoppingName;
    }

    /**
     * @param shoppingName
     */
    public void setShoppingName(String shoppingName) {
        this.shoppingName = shoppingName;
    }

    public String getShoppingClass() {
        return shoppingClass;
    }

    public void setShoppingClass(String shoppingClass) {
        this.shoppingClass = shoppingClass;
    }

    public String getShoppingContact() {
        return shoppingContact;
    }

    public void setShoppingContact(String shoppingContact) {
        this.shoppingContact = shoppingContact;
    }
}