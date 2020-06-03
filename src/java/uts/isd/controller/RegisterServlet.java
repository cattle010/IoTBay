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
import uts.isd.model.*;
import uts.isd.model.dao.*;

/**
 *
 * @author jason
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        HttpSession session = request.getSession();       
        Validator validator = new Validator();        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");  
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
        User user = null;
        validator.clear(session);
    
        try {
            if (userDAO.checkUser(email)) {
                session.setAttribute("existErr", "This user already exists");
                request.getRequestDispatcher("register.jsp").include(request, response);
            } else if (!validator.checkRegisterEmpty(firstName, lastName, email, password, phoneNumber)) {           
                session.setAttribute("emptyErr", "Error: Please fill in the required fields");
                request.getRequestDispatcher("register.jsp").include(request, response);
            } else if (!validator.validateName(firstName)) {           
                session.setAttribute("nameErr", "Error: First name format incorrect");
                request.getRequestDispatcher("register.jsp").include(request, response);
            } else if (!validator.validateName(lastName)) {           
                session.setAttribute("nameErr", "Error: Last name format incorrect");
                request.getRequestDispatcher("register.jsp").include(request, response);
            } else if (!validator.validateEmail(email)) {           
                session.setAttribute("emailErr", "Error: Email format incorrect");
                request.getRequestDispatcher("register.jsp").include(request, response);
            } else if (!validator.validatePassword(password)) {                  
                session.setAttribute("passErr", "Error: Password format incorrect");
                request.getRequestDispatcher("register.jsp").include(request, response);
            } else if (!phoneNumber.isEmpty()) {
                    if (!validator.validatePhoneNumber(phoneNumber)) {
                        session.setAttribute("phoneErr", "Error: Phone number format incorrect");
                        request.getRequestDispatcher("register.jsp").include(request, response);
                    }
                    else {
                        try {
                            userDAO.addUser(email, firstName, lastName, password, phoneNumber);
                        } catch (SQLException ex) {
                            session.setAttribute("addErr", "Error: User was not added to the database");
                            request.getRequestDispatcher("register.jsp").include(request, response);
                }
                        }                
            } else {
                try {
                    userDAO.addUser(email, firstName, lastName, password, phoneNumber);
                } catch (SQLException ex) {
                    session.setAttribute("addErr", "Error: User was not added to the database");
                    request.getRequestDispatcher("register.jsp").include(request, response);
                }
                request.getRequestDispatcher("index.jsp").include(request, response);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }
}
