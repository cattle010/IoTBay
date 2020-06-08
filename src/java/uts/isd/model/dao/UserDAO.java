/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import uts.isd.model.User;

/**
 *
 * @author jason
 */
public class UserDAO {
    private Statement st;
    private Connection conn;
    
    public UserDAO (Connection conn) throws SQLException {
        st = conn.createStatement();
        this.conn = conn;
    }
    
    //Create User
    public void addUser(String userEmail, String userFirstName, String userLastName, String password, String phoneNumber) throws SQLException {
        String query = "INSERT INTO iotbayadmin.USER_T(UserEmail, UserFirstName, UserLastName, Password, PhoneNumber, IsStaffUser, IsRegisteredUser) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, userEmail);
            pstmt.setString(2, userFirstName);
            pstmt.setString(3, userLastName);
            pstmt.setString(4, password);
            pstmt.setString(5, phoneNumber);
            pstmt.setBoolean(6, false);
            pstmt.setBoolean(7, true);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Read User
    public User findUser(String userEmail) throws SQLException {
        String fetch = "SELECT * FROM iotbayadmin.USER_T WHERE USEREMAIL=?";
        PreparedStatement pstmt = conn.prepareStatement(fetch);
        pstmt.setString(1, userEmail);
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()) {
            int id = rs.getInt(1);
            String email = rs.getString(2);
            String firstName = rs.getString(3);
            String lastName = rs.getString(4);
            String password = rs.getString(5);
            String phoneNumber = rs.getString(6);            
            Boolean isStaff = rs.getBoolean(7);
            Boolean isCustomer = rs.getBoolean(8);
            pstmt.close();
            return new User(id, email, firstName, lastName, password, phoneNumber, isStaff, isCustomer);            
        }
        pstmt.close();
        return null;
    }
    
    //Update User
    public void updateUser(int id, String userEmail, String userFirstName, String userLastName, String password, String phoneNumber) throws SQLException {        
        String query = "UPDATE iotbayadmin.USER_T SET UserEmail=?, UserFirstName=?, UserLastName=?, Password=?, PhoneNumber=?, isStaffUser=?, isRegisteredUser=? WHERE UserId = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, userEmail);
        pstmt.setString(2, userFirstName);
        pstmt.setString(3, userLastName);
        pstmt.setString(4, password);
        pstmt.setString(5, phoneNumber);
        pstmt.setBoolean(6, false);
        pstmt.setBoolean(7, true);
        pstmt.setInt(8, id);
        pstmt.executeUpdate();
        pstmt.close();
    }
    
    //Delete User
    public void deleteUser(int userID) throws SQLException {
        String query = "DELETE FROM iotbayadmin.USER_T WHERE UserID=?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, userID);
        pstmt.executeUpdate();
        pstmt.close();
    }
    
    //Check User in Database
    public boolean checkUser(String userEmail) throws SQLException {
        String query = "SELECT * FROM iotbayadmin.USER_T WHERE USEREMAIL=?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, userEmail);
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()) {
            String email = rs.getString(1);           
            if (userEmail.equals(email)) {
                pstmt.close();
                return true;
            }
        }        
        return false;
    }
    
        //Show USER Info onto User List
    public ArrayList<User> ShowUser() throws SQLException{
        String query = "SELECT * FROM iotbayadmin.USER_T ORDER BY UserID";
        ArrayList<User> UserList = new ArrayList<User>();
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {
            User user = new User(rs.getInt("UserID"), rs.getString("UserEmail"), rs.getString("UserFirstName"), rs.getString("UserLastName"), rs.getString("Password"), rs.getString("PhoneNumber"), rs.getBoolean("isStaffUser"),rs.getBoolean("isRegisteredUser"));
            UserList.add(user);
        } 
        
        return UserList;
    }
}
