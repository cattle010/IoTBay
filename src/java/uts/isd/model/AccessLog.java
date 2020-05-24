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
public class AccessLog implements Serializable {
    private int accessLogID;
    private int userID;
    private Date userLoginTime;
    private Date userLogoutTime;

    public AccessLog(int accessLogID, int userID, Date userLoginTime, Date userLogoutTime) {
        this.accessLogID = accessLogID;
        this.userID = userID;
        this.userLoginTime = userLoginTime;
        this.userLogoutTime = userLogoutTime;
    }

    public int getAccessLogID() {
        return accessLogID;
    }

    public void setAccessLogID(int accessLogID) {
        this.accessLogID = accessLogID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getUserLoginTime() {
        return userLoginTime;
    }

    public void setUserLoginTime(Date userLoginTime) {
        this.userLoginTime = userLoginTime;
    }

    public Date getUserLogoutTime() {
        return userLogoutTime;
    }

    public void setUserLogoutTime(Date userLogoutTime) {
        this.userLogoutTime = userLogoutTime;
    }
    
}
