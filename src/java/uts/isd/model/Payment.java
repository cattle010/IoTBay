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
public class Payment implements Serializable {
    private int paymentID;
    private String paymentName;
    private String paymentStatus;
    private double paymentAmount;
    private Date paymentDate;

    public Payment(int paymentID, String paymentName, String paymentStatus, double paymentAmount, Date paymentDate) {
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
    
    
}

