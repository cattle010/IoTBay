/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author jason
 */
public class Order implements Serializable {
    private int orderID;
    private int userID;
    private int paymentID;
    private int shippingAddressID;
    private Date orderDate;
    private Date shipDate;
    private String orderStatus;

    public Order(int orderID, int userID, int paymentID, int shippingAddressID, Date orderDate, Date shipDate, String orderStatus) {
        this.orderID = orderID;
        this.userID = userID;
        this.paymentID = paymentID;
        this.shippingAddressID = shippingAddressID;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.orderStatus = orderStatus;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getShippingAddressID() {
        return shippingAddressID;
    }

    public void setShippingAddressID(int shippingAddressID) {
        this.shippingAddressID = shippingAddressID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    
}
