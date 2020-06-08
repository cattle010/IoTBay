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
    private long cardNumber;
    private Date cardValid;
    private Date cardExpire;
    private int cardSecurityNum;

    public Payment(int paymentID, String paymentName, String paymentStatus, double paymentAmount, Date paymentDate, String paymentMethod, String cardFName, String cardLName, long cardNumber, Date cardValid, Date cardExpire, int cardSecurityNum) {
        this.paymentID = paymentID;
        this.paymentName = paymentName;
        this.paymentStatus = paymentStatus;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.cardFName = cardFName;
        this.cardLName = cardLName;
        this.cardNumber = cardNumber;
        this.cardValid = cardValid;
        this.cardExpire = cardExpire;
        this.cardSecurityNum = cardSecurityNum;
    }
    
}

