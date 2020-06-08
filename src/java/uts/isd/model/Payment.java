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
 * Mamoon -> Modified Model to include card details
 */
public class Payment implements Serializable {
    private int paymentID;
    private String paymentName;
    private String paymentStatus;
    private double paymentAmount;
    private Date paymentDate;
    private String paymentMethod;
    private String cardFName;
    private String cardLName;
    private int cardNumber;
    private Date cardValid;
    private Date cardExpire;
    private int cardSecurityNum;
    

    public Payment(int paymentID, String paymentName, String paymentStatus, double paymentAmount, Date paymentDate, String paymentMethod, String cardFName, String cardLName,int cardNumber, Date cardValid, Date cardExpire, int cardSecurityNum) {
        this.paymentID = paymentID;
        this.paymentName = paymentName;
        this.paymentStatus = paymentStatus;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCardFName() {
        return cardFName;
    }

    public void setCardFName(String cardFName) {
        this.cardFName = cardFName;
    }

    public String getCardLName() {
        return cardLName;
    }

    public void setCardLName(String cardLName) {
        this.cardLName = cardLName;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getCardValid() {
        return cardValid;
    }

    public void setCardValid(Date cardValid) {
        this.cardValid = cardValid;
    }

    public Date getCardExpire() {
        return cardExpire;
    }

    public void setCardExpire(Date cardExpire) {
        this.cardExpire = cardExpire;
    }

    public int getCardSecurityNum() {
        return cardSecurityNum;
    }

    public void setCardSecurityNum(int cardSecurityNum) {
        this.cardSecurityNum = cardSecurityNum;
    }
    
    
}

