/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import uts.isd.model.Payment;

/**
 *
 * @author mamoo
 */
public class PaymentDAO {
    private Statement st;
    private Connection conn;
    
    public PaymentDAO (Connection conn) throws SQLException {
        st = conn.createStatement();
        this.conn = conn;
    }
    
    //Create Payment
    public void addPayment(int PaymentID, String PaymentName) throws SQLException {
        String query = "INSERT INTO iotbayadmin.ACCESSLOG_T(PaymentID, PaymentName, PaymentStatus, PaymentAmount, PaymentDate, PaymentMethod, CardFName, CardLName, CardNumber, CardValid, CardExpire, CardSecurityNum) VALUES (?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, PaymentID);
        pstmt.setString(2, PaymentName);
        pstmt.executeUpdate();
        pstmt.close();
    }
    //Read Payment
        public ArrayList<Payment> fetchAllPayments(int PaymentID) throws SQLException {
        ArrayList<Payment> retrievedPayments = new ArrayList<Payment>();
        String query = "SELECT * FROM iotbayadmin.PAYMENT_T WHERE PaymentID IS NOT NULL";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, PaymentID);
        ResultSet rs = pstmt.executeQuery();        
        
        while (rs.next()) {
            int PaymentIDS = rs.getInt(1);
            String name = rs.getString(2);
            String status = rs.getString(3);
            double amount = rs.getDouble(4);
            Date payDate = rs.getDate(5);
            String method = rs.getString(6);
            String fName = rs.getString(7);
            String lName = rs.getString(8);
            long cardNumber = rs.getLong(9);
            Date valid = rs.getDate(10);
            Date expire = rs.getDate(11);
            int security = rs.getInt(12);
            retrievedPayments.add(new Payment(PaymentIDS, name, status, amount, payDate, method, fName, lName, cardNumber, valid, expire, security));
        }
        
        return retrievedPayments;        
    }
    //Update Payment
    //Delete Payment
}

