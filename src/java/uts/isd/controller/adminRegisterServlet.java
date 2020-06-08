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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.*;
import uts.isd.model.dao.*;

/**
 *
 * @author xun.s.chang
 */
@WebServlet("/adminRegisterServlet")
public class adminRegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        validator.clear(session);
        request.getRequestDispatcher("adminRegister.jsp").include(request, response);
    } 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        HttpSession session = request.getSession();       
        Validator validator = new Validator();        
        String firstName = request.getParameter("firstName").trim();
        String lastName = request.getParameter("lastName").trim();
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();
        String phoneNumber = request.getParameter("phoneNumber").trim();  
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");        
        validator.clear(session);
    
        try {
            User user = userDAO.findUser(email);
            if (user != null) {
                session.setAttribute("existErr", "Error: This email already exists in the system");
                request.getRequestDispatcher("adminRegister.jsp").include(request, response);            
            } else if (!validator.validateName(firstName)) {           
                session.setAttribute("firstNameErr", "Error: First name format incorrect");
                request.getRequestDispatcher("adminRegister.jsp").include(request, response);
            } else if (!validator.validateName(lastName)) {           
                session.setAttribute("lastNameErr", "Error: Last name format incorrect");
                request.getRequestDispatcher("adminRegister.jsp").include(request, response);
            } else if (!validator.validateEmail(email)) {           
                session.setAttribute("emailErr", "Error: Email format incorrect");
                request.getRequestDispatcher("adminRegister.jsp").include(request, response);
            } else if (!validator.validatePassword(password)) {                  
                session.setAttribute("passErr", "Error: Password format incorrect");
                request.getRequestDispatcher("adminRegister.jsp").include(request, response);
            } else if (!phoneNumber.isEmpty()) {
                    if (!validator.validatePhoneNumber(phoneNumber)) {
                        session.setAttribute("phoneErr", "Error: Phone number format incorrect");
                        request.getRequestDispatcher("adminRegister.jsp").include(request, response);
                    }
                    else {
                        try {
                            userDAO.addUser(email, firstName, lastName, password, phoneNumber);
                            response.sendRedirect("ListUserServlet");                
                        } catch (SQLException ex) {
                            session.setAttribute("addErr", "Error: User was not added to the database");
                            response.sendRedirect("adminRegister.jsp");
                        }
                    }                
            } else {
                try {
                    userDAO.addUser(email, firstName, lastName, password, phoneNumber);
                    response.sendRedirect("ListUserServlet");                
                } catch (SQLException ex) {
                    session.setAttribute("addErr", "Error: User was not added to the database");
                    response.sendRedirect("adminRegister.jsp");
                }                
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}