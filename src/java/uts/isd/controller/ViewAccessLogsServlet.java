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
        validator.clear(session);
        
        if (startDate != null & endDate != null) {                        
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date formattedStartDate = sdf.parse(startDate);
                Date formattedEndDate = sdf.parse(endDate);
                Timestamp startTimeStamp = new Timestamp(formattedStartDate.getTime());
                Timestamp endTimeStamp = new Timestamp(formattedEndDate.getTime());                
                if (startTimeStamp.after(endTimeStamp)) {
                    session.setAttribute("backToTheFutureErr", "Error: The start date cannot be after the end date");
                    request.getRequestDispatcher("accesslog.jsp").include(request, response); 
                } else {                    
                    ArrayList<AccessLog> retrievedLogs = new ArrayList<AccessLog>();        
                    User currentUser = (User) session.getAttribute("user");
                    int userID = currentUser.getUserID();              
                    retrievedLogs = accessLogDAO.fetchLogsByDate(userID, startTimeStamp, endTimeStamp);
                    session.setAttribute("accessLogs", retrievedLogs);
                    request.getRequestDispatcher("accesslog.jsp").include(request, response);    
                }                
            } catch (ParseException | SQLException ex) {            
                Logger.getLogger(ViewAccessLogsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }   
    }   
}
