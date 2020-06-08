/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.controller.Validator;
import uts.isd.model.*;
import uts.isd.model.dao.*;


/**
 *
 * @author jason
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        validator.clear(session);
        request.getRequestDispatcher("login.jsp").include(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
        AccessLogDAO accessLogDAO = (AccessLogDAO) session.getAttribute("accessLogDAO");
        User user = null;
        validator.clear(session);      
        
        try {         
            user = userDAO.findUser(email);
        } catch (SQLException ex) {           
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);       
        }
        
        if (!validator.validateEmail(email)) {           
            session.setAttribute("emailErr", "Error: Email format incorrect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {                  
            session.setAttribute("passErr", "Error: Password format incorrect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } else if (user != null) {
            if (user.getPassword().equals(password)) {
                session.setAttribute("user", user);
                try {
                    accessLogDAO.addLog(user.getUserID(), "User Logged In");
                } catch (SQLException ex) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.getRequestDispatcher("index.jsp").include(request, response);
            } else {
                session.setAttribute("loginErr", "Error: The user cannot be found in the database, please check your login details again");
                request.getRequestDispatcher("login.jsp").include(request, response);
            }                        
        } else {                       
            session.setAttribute("existErr", "Error: The user does not exist in the database");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }   
    }
}