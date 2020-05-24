/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 *
 * @author jason
 */
public class User implements Serializable {
    private int userID;
    private String userEmail;
    private String userFirstName;
    private String userLastName;
    private String password;
    private String phoneNumber;
    private boolean isStaffUser;
    private boolean isRegisteredUser;
    
    public User(int userID, String userEmail, String userFirstName, String userLastName, String password, String phoneNumber, boolean isStaffUser, boolean isRegisteredUser) {
        this.userID = userID;
        this.userEmail = userEmail;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.isStaffUser = isStaffUser;
        this.isRegisteredUser = isRegisteredUser;
    }    

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isIsStaffUser() {
        return isStaffUser;
    }

    public void setIsStaffUser(boolean isStaffUser) {
        this.isStaffUser = isStaffUser;
    }

    public boolean isIsRegisteredUser() {
        return isRegisteredUser;
    }

    public void setIsRegisteredUser(boolean isRegisteredUser) {
        this.isRegisteredUser = isRegisteredUser;
    }
    
}
