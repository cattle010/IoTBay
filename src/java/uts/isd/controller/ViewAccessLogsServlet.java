/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.AccessLog;
import uts.isd.model.User;
import uts.isd.model.dao.AccessLogDAO;
import uts.isd.model.dao.UserDAO;


/**
 *
 * @author jason
 */
public class ViewAccessLogsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        HttpSession session = request.getSession();                           
        Validator validator = new Validator();
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
        AccessLogDAO accessLogDAO = (AccessLogDAO) session.getAttribute("accessLogDAO");                                
        validator.clear(session);
        try {
            ArrayList<AccessLog> retrievedLogs = new ArrayList<AccessLog>();        
            User currentUser = (User) session.getAttribute("user");
            int userID = currentUser.getUserID();              
            retrievedLogs = accessLogDAO.fetchAllLogs(userID);
            session.setAttribute("accessLogs", retrievedLogs);
            session.setAttribute("filterText", "You are viewing all of your logs");
        } catch (NullPointerException | SQLException ex) {
            Logger.getLogger(ViewAccessLogsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }                              
        request.getRequestDispatcher("accesslog.jsp").include(request, response);        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(); 
        Validator validator = new Validator();
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
        AccessLogDAO accessLogDAO = (AccessLogDAO) session.getAttribute("accessLogDAO");                                
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        ArrayList<AccessLog> retrievedLogs = new ArrayList<AccessLog>();
        Timestamp presentDay = new Timestamp(new Date().getTime()); 
        User currentUser = (User) session.getAttribute("user");
        int userID = currentUser.getUserID();              
        validator.clear(session);
        
        //Checks if the start date and end date field and return all logs if they are both empty
        if (startDate.isEmpty() && endDate.isEmpty()) {
            try {                                        
                retrievedLogs = accessLogDAO.fetchAllLogs(userID);
                session.setAttribute("accessLogs", retrievedLogs);
                session.setAttribute("filterText", "You are viewing all of your logs");
                request.getRequestDispatcher("accesslog.jsp").include(request, response);        
            } catch (NullPointerException | SQLException ex) {
                Logger.getLogger(ViewAccessLogsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }          
        } 
        
        //Checks if the start date is entered and the end date is empty, will return all the logs from the start date until today.
        else if (!startDate.isEmpty() && endDate.isEmpty()) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");                
                Date formattedStartDate = sdf.parse(startDate);                
                Timestamp startTimeStamp = new Timestamp(formattedStartDate.getTime());
                //Check position of start and end dates and return relevent error messages to user
                if (presentDay.before(startTimeStamp)) {
                    if (startTimeStamp.after(presentDay)) {
                        session.setAttribute("timeFilterErr", "Error: The start date must be before todays date");
                        request.getRequestDispatcher("accesslog.jsp").include(request, response);                
                    } else {
                        session.setAttribute("timeFilterErr", "Error: The start date must come before the end date");
                        request.getRequestDispatcher("accesslog.jsp").include(request, response);                
                    }                    
                } else {                                                                                   
                    retrievedLogs = accessLogDAO.fetchLogsByDate(userID, startTimeStamp, presentDay);
                    session.setAttribute("accessLogs", retrievedLogs);
                    session.setAttribute("filterText", "You are viewing your logs from " + (getPrettyLogEventTime(formattedStartDate)) + " to " + (getPrettyLogEventTime(presentDay)));
                    request.getRequestDispatcher("accesslog.jsp").include(request, response);    
                }                
            } catch (ParseException ex) {            
                session.setAttribute("dateParseError", "Error: The date must be in the format dd/mm/yyyy");
                request.getRequestDispatcher("accesslog.jsp").include(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ViewAccessLogsServlet.class.getName()).log(Level.SEVERE, null, ex);
                session.setAttribute("filterErr", "Error: The date must be in the format dd/mm/yyyy");
                request.getRequestDispatcher("accesslog.jsp").include(request, response);   
            }
        } 
        
        //Checks if the end date is entered and the start date is empty, will return all the logs from the first record till the end date
        else if (startDate.isEmpty() && !endDate.isEmpty()) {
            try {                                                                                         
                AccessLog accessLog = accessLogDAO.fetchFirstLog(userID);
                String firstLog = accessLog.getLogEventTime().toString();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");                
                Date formattedEndDate = sdf.parse(endDate);                
                Date formattedStartDate = sdf.parse(firstLog);                
                Timestamp endTimeStamp = new Timestamp(formattedEndDate.getTime()); 
                Timestamp startTimeStamp = new Timestamp(formattedStartDate.getTime()); 
                //Check position of start and end dates and return relevent error messages to user
                if (endTimeStamp.before(startTimeStamp)) {                    
                    if (startTimeStamp.after(presentDay)) {
                        session.setAttribute("timeFilterErr", "Error: The start date must be before todays date");
                        request.getRequestDispatcher("accesslog.jsp").include(request, response);                
                    } else {
                        session.setAttribute("timeFilterErr", "Error: Your selected end date is before your account registration, please select another date");
                        request.getRequestDispatcher("accesslog.jsp").include(request, response);                
                    }
                } else {                                                            
                    retrievedLogs = accessLogDAO.fetchLogsByDate(userID, startTimeStamp, endTimeStamp);
                    session.setAttribute("accessLogs", retrievedLogs);
                    session.setAttribute("filterText", "You are viewing your logs from " + (getPrettyLogEventTime(formattedStartDate)) + " to " + (getPrettyLogEventTime(formattedEndDate)));
                    request.getRequestDispatcher("accesslog.jsp").include(request, response);    
                }                
            } catch (ParseException ex) {            
                session.setAttribute("dateParseError", "Error: The date must be in the format dd/mm/yyyy");
                request.getRequestDispatcher("accesslog.jsp").include(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ViewAccessLogsServlet.class.getName()).log(Level.SEVERE, null, ex);
                session.setAttribute("filterErr", "Error: The date must be in the format dd/mm/yyyy");
                request.getRequestDispatcher("accesslog.jsp").include(request, response);   
            }
        } 
        
        //Check if both start and end dates have been populated, then returns access logs based on the dates provided
        else if (startDate != null & endDate != null) {                        
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date formattedStartDate = sdf.parse(startDate);
                Date formattedEndDate = sdf.parse(endDate);
                Timestamp startTimeStamp = new Timestamp(formattedStartDate.getTime());
                Timestamp endTimeStamp = new Timestamp(formattedEndDate.getTime());  
                //Check position of start and end dates and return relevent error messages to user
                if (endTimeStamp.before(startTimeStamp)) {                    
                    if (startTimeStamp.after(presentDay)) {
                        session.setAttribute("timeFilterErr", "Error: The start date must be before todays date");
                        request.getRequestDispatcher("accesslog.jsp").include(request, response);                
                    } else {
                        session.setAttribute("timeFilterErr", "Error: The start date must come before the end date");
                        request.getRequestDispatcher("accesslog.jsp").include(request, response);                
                    }
                } else {                                                            
                    retrievedLogs = accessLogDAO.fetchLogsByDate(userID, startTimeStamp, endTimeStamp);
                    session.setAttribute("accessLogs", retrievedLogs);
                    session.setAttribute("filterText", "You are viewing your logs from " + (getPrettyLogEventTime(formattedStartDate)) + " to " + (getPrettyLogEventTime(formattedEndDate)));
                    request.getRequestDispatcher("accesslog.jsp").include(request, response);    
                }                
            } catch (ParseException ex) {            
                session.setAttribute("dateParseError", "Error: The date must be in the format dd/mm/yyyy");
                request.getRequestDispatcher("accesslog.jsp").include(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ViewAccessLogsServlet.class.getName()).log(Level.SEVERE, null, ex);
                session.setAttribute("filterErr", "Error: The date must be in the format dd/mm/yyyy");
                request.getRequestDispatcher("accesslog.jsp").include(request, response);   
            }           
        } 
        
        //Check if start date or end date are somehow null and send appropriate error message back to the user
        else if (startDate == null && endDate == null) {
            session.setAttribute("filterText", "An error has occurred and both Start Date and End Date are empty, please contact the Site Administrator to report this issue");
            request.getRequestDispatcher("accesslog.jsp").include(request, response);   
        }
    }
    
    //Helper method to make Date datatypes readable
    public String getPrettyLogEventTime(Date logEventTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy");
        return sdf.format(logEventTime);
    }   
}
