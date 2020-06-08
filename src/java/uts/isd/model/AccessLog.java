/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jason
 */
public class AccessLog implements Serializable {
    private int accessLogID;
    private int userID;
    private Date logEventTime;
    private String logEvent;

    public AccessLog(int accessLogID, int userID, Date logEventTime, String logEvent) {
        this.accessLogID = accessLogID;
        this.userID = userID;
        this.logEventTime = logEventTime;
        this.logEvent = logEvent;
    }

    public void setAccessLogID(int accessLogID) {
        this.accessLogID = accessLogID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setLogEventTime(Date logEventTime) {
        this.logEventTime = logEventTime;
    }

    public void setLogEvent(String logEvent) {
        this.logEvent = logEvent;
    }

    public int getAccessLogID() {
        return accessLogID;
    }

    public int getUserID() {
        return userID;
    }

    public Date getLogEventTime() {
        return logEventTime;
    }
    
    public String getPrettyLogEventTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy 'at' h:mm a");
        return sdf.format(logEventTime);
    }       

    public String getLogEvent() {
        return logEvent;
    }    
}
