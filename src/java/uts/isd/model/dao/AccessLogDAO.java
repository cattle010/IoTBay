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
import java.sql.Timestamp;
import java.util.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import uts.isd.model.AccessLog;

/**
 *
 * @author jason
 */
public class AccessLogDAO {
    private Statement st;
    private Connection conn;
    
    public AccessLogDAO (Connection conn) throws SQLException {
        st = conn.createStatement();
        this.conn = conn;
    }
    
    //CREATE AccessLog Operation
    public void addLog(int userID, String logEvent) throws SQLException {
        String query = "INSERT INTO iotbayadmin.ACCESSLOG_T(UserID, LogEventTime, LogEvent) VALUES (?, ?, ?)";
        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, userID);
        pstmt.setTimestamp(2, time);
        pstmt.setString(3, logEvent);
        pstmt.executeUpdate();
        pstmt.close();
    }
    
    //READ AccessLog Operation
    public ArrayList<AccessLog> fetchAllLogs(int id) throws SQLException {
        ArrayList<AccessLog> retrievedLogs = new ArrayList<AccessLog>();
        String query = "SELECT * FROM iotbayadmin.ACCESSLOG_T WHERE UserId = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();        
        
        while (rs.next()) {
            int accessLogID = rs.getInt(1);
            int userID = rs.getInt(2);
            Timestamp time = rs.getTimestamp(3);
            String event = rs.getString(4);
            retrievedLogs.add(new AccessLog(accessLogID, userID, time, event));
        }
        
        return retrievedLogs;        
    }
    
    //FIND BY DATE AccessLog Operation
    public ArrayList<AccessLog> fetchLogsByDate(int id, Timestamp start, Timestamp end) throws SQLException {
        ArrayList<AccessLog> retrievedLogs = new ArrayList<AccessLog>();
        String query = "SELECT * FROM iotbayadmin.ACCESSLOG_T WHERE UserId = ? AND LogEventTime >= ? AND LogEventTime <= ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, id);
        pstmt.setTimestamp(2, start);
        pstmt.setTimestamp(3, end);
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()) {
            int accessLogID = rs.getInt(1);
            int userID = rs.getInt(2);
            Timestamp time = rs.getTimestamp(3);
            String event = rs.getString(4);
            retrievedLogs.add(new AccessLog(accessLogID, userID, time, event));
        }        
        return retrievedLogs;
    }
    
    //READ the first AccessLog of a User Operation
    public AccessLog fetchFirstLog(int id) throws SQLException {        
        String query = "SELECT * FROM iotbayadmin.ACCESSLOG_T WHERE UserId = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();        
        
        if (rs.next()) {
            int accessLogID = rs.getInt(1);
            int userID = rs.getInt(2);
            Timestamp time = rs.getTimestamp(3);
            String event = rs.getString(4);
            pstmt.close();
            return (new AccessLog(accessLogID, userID, time, event));          
        }
        pstmt.close();
        return null;        
    }
}
