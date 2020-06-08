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
    public void addPayment(String PaymentName, String PaymentStatus, double PaymentAmount, Date PaymentDate, String PaymentMethod, String CardFName, String CardLName, long CardNumber, Date CardValid, Date CardExpire, int CardSecurityNum) throws SQLException {
        String query = "INSERT INTO iotbayadmin.PAYMENT_T(PaymentName, PaymentStatus, PaymentAmount, PaymentDate, PaymentMethod, CardFName, CardLName, CardNumber, CardValid, CardExpire, CardSecurityNum) VALUES (?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, PaymentName);
        pstmt.setString(2, PaymentStatus);
        pstmt.setDouble(3, PaymentAmount);
        pstmt.setDate(4, (java.sql.Date) PaymentDate);
        pstmt.setString(5, PaymentMethod);
        pstmt.setString(6, CardFName);
        pstmt.setString(7, CardLName);
        pstmt.setLong(8, CardNumber);
        pstmt.setDate(9, (java.sql.Date) CardValid);
        pstmt.setDate(10, (java.sql.Date) CardExpire);
        pstmt.setInt(11, CardSecurityNum);
        pstmt.executeUpdate();
        pstmt.close();
    }
    //Read Payment
        public ArrayList<Payment> searchPayment(String searchID) throws SQLException {
        ArrayList<Payment> searchPayments = new ArrayList();
        String search = "Select * from iotbayadmin.PAYMENT_T where PaymentID=" + searchID ;
        ResultSet rs = st.executeQuery(search);
        
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
            searchPayments.add(new Payment(PaymentIDS, name, status, amount, payDate, method, fName, lName, cardNumber, valid, expire, security));
        }
        if(searchPayments.size() > 0){
            return searchPayments;
        }
        else{
            return null;
        }
    }
        public ArrayList<Payment> fetchPayments() throws SQLException {
        ArrayList<Payment> payments = new ArrayList();
        String fetch = "Select * from iotbayadmin.PAYMENT_T";
        ResultSet rs = st.executeQuery(fetch);
        
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
            payments.add(new Payment(PaymentIDS, name, status, amount, payDate, method, fName, lName, cardNumber, valid, expire, security));
        }
        return payments;
    }
        public boolean checkPayment(String PaymentID) throws SQLException{
       String fetch = "select * from iotbayadmin.PAYMENT_T where PaymentID = '" + PaymentID + "'";
       ResultSet rs = st.executeQuery(fetch);
       
       while(rs.next()) {
           String userPayment = rs.getString(1);
           
           if (userPayment.equals(PaymentID)) {
               return true;
           }
       }
       return false;
   }
        
        
        
         //Update Payment
        public void updatePayment(String PaymentName, String PaymentStatus, double PaymentAmount, Date PaymentDate, String PaymentMethod, String CardFName, String CardLName, long CardNumber, Date CardValid, Date CardExpire, int CardSecurityNum) throws SQLException{
        st.executeUpdate("UPDATE iotbayadmin.PAYMENT_T SET PaymentName='" + PaymentName + "', PaymentStatus'=" + PaymentStatus +"', PaymentAmount='" + PaymentAmount +"', PaymentDate='" + PaymentDate +"', PaymentMethod='" + PaymentMethod +"', CardFName='" + CardFName + "', CardLName='" + CardLName + "', CardNumber'" + CardNumber + "', CardValid'" + CardValid + "', CardExpire'" + CardExpire + "', CardSecurityNum'" + CardSecurityNum);
    }
        //Delete Payment
        public void deletePayment(int PaymentID) throws SQLException {
        st.executeUpdate("DELETE FROM iotbayadmin.PAYMENT_T WHERE PaymentID='" + PaymentID + "'");
    }
        
        
   
    
}

