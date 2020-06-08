/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

/**
 *
 * @author Kelvin Wang
 */
import uts.isd.model.Order;
import java.util.ArrayList;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import uts.isd.model.Order;
/**
 *
 * @author apple
 */
public class OrderDBManager {

    public static Order findOrder(String orderID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private final Statement st;
    private final Connection conn;
    
    public OrderDBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
        this.conn = conn;
    }
 public Order findOrder(int orderID) throws SQLException {   
   String fetch = "select * from iotbayadmin.ORDER_T where OrderID= '" + orderID + "'";
        try (PreparedStatement pst = conn.prepareStatement(fetch)) {
            pst.setInt(1, orderID);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()) {
                int userID = rs.getInt(2);
                int paymentID = rs.getInt(3);
                int shippingAddressID = rs.getInt(4);
                Date orderDate = rs.getDate(5);
                Date shipDate = rs.getDate(6);
                String orderStatus = rs.getString(7);
                pst.close();
                return new Order(orderID, userID, paymentID, shippingAddressID, orderDate, shipDate, orderStatus);            
            }
        }
   return null;   
}

//Add a user-data into the database   
public void addOrder(int orderID,int userID,int paymentID,int shippingAddressID,Date orderDate,Date shipDate,String orderStatus) throws SQLException {                   //code for add-operation       
  st.executeUpdate("sql query");   
  String query = "INSERT INTO iotbayadmin.ORDER_T(orderID, userID, paymentID, shippingAddressID, orderDate, shipDate, orderStatus) VALUES (?, ?, ?, ?, ?, ?, ?)";
  try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setInt(1, orderID);
            pst.setInt(2, userID);
            pst.setInt(3, paymentID);
            pst.setInt(4, shippingAddressID);
            pst.setDate(5, orderDate);
            pst.setDate(6, shipDate);
            pst.setString(7, orderStatus);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
}
 
public void updateOrder(int orderID,int userID,int paymentID,int shippingAddressID,Date orderDate,Date shipDate,String orderStatus) throws SQLException {       
   String query = "UPDATE iotbayadmin.ORDER_T SET =?, ORDERID=?, USERID=?,PAYMENTID=?, SHIPPINGADDRESSID=?, ORDERDATE=?, SHIPDATE=?, ORDERSTATUS=? WHERE ORDERID = ?";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setInt(1, orderID);
            pst.setInt(2, userID);
            pst.setInt(3, paymentID);
            pst.setInt(4, shippingAddressID);
            pst.setDate(5, orderDate);
            pst.setDate(6, shipDate);
            pst.setString(7, orderStatus);
            pst.executeUpdate();
            pst.close();
        }
}       
   
public void deleteOrder(int orderID) throws SQLException{       
   String query = "DELETE FROM iotbayadmin.ORDER_T WHERE ORDERID=?";
        try(PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setInt(1, orderID);
            pst.executeUpdate();
            pst.close();
        }
}
}
