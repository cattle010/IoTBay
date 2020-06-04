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
import uts.isd.model.User;
import uts.isd.model.dao.UserDAO;

/**
 *
 * @author jason
 */
public class EditUserServlet extends HttpServlet {
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
        User currentUser = (User) session.getAttribute("user");
        User user = null;
        int userID = currentUser.getUserID();
        validator.clear(session);
        
        try {
            user = userDAO.findUser(email);
           if (!validator.validateName(firstName)) {           
            session.setAttribute("firstNameErr", "Error: First name format incorrect");
            request.getRequestDispatcher("editUserDetails.jsp").include(request, response);
        } else if (!validator.validateName(lastName)) {           
            session.setAttribute("lastNameErr", "Error: Last name format incorrect");
            request.getRequestDispatcher("editUserDetails.jsp").include(request, response);
        } else if (!validator.validateEmail(email)) {           
            session.setAttribute("emailErr", "Error: Email format incorrect");
            request.getRequestDispatcher("editUserDetails.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {                  
            session.setAttribute("passErr", "Error: Password format incorrect");
            request.getRequestDispatcher("editUserDetails.jsp").include(request, response);
        } else if (!phoneNumber.isEmpty()) {
                if (!validator.validatePhoneNumber(phoneNumber)) {
                    session.setAttribute("phoneErr", "Error: Phone number format incorrect");
                    request.getRequestDispatcher("editUserDetails.jsp").include(request, response);
                }
                else {
                    try {
                        if (user == null) {
                            userDAO.updateUser(userID, email, firstName, lastName, password, phoneNumber);
                            User updatedUser = userDAO.findUser(email);
                            session.setAttribute("user", updatedUser);
                            request.getRequestDispatcher("account.jsp").include(request, response);
                        } else {
                            if (email.equals(currentUser.getUserEmail())) {
                                userDAO.updateUser(userID, email, firstName, lastName, password, phoneNumber);
                                User updatedUser = userDAO.findUser(email);
                                session.setAttribute("user", updatedUser);
                                request.getRequestDispatcher("account.jsp").include(request, response);
                            }
                            else {
                                session.setAttribute("emailExistErr", "Error: Email already exists in database");
                                request.getRequestDispatcher("editUserDetails.jsp").include(request, response);
                            }
                        }                                                
                    } catch (SQLException ex) {
                        session.setAttribute("updateErr", "Error: User was not updated successfully");
                        request.getRequestDispatcher("editUserDetails.jsp").include(request, response);
                    }
                }
            } else {
                try {
                        if (user == null) {
                            userDAO.updateUser(userID, email, firstName, lastName, password, phoneNumber);
                            User updatedUser = userDAO.findUser(email);
                            session.setAttribute("user", updatedUser);
                            request.getRequestDispatcher("account.jsp").include(request, response);
                        } else {
                            if (email.equals(currentUser.getUserEmail())) {
                                userDAO.updateUser(userID, email, firstName, lastName, password, phoneNumber);
                                User updatedUser = userDAO.findUser(email);
                                session.setAttribute("user", updatedUser);
                                request.getRequestDispatcher("account.jsp").include(request, response);
                            }
                            else {
                                session.setAttribute("emailExistErr", "Error: Email already exists in database");
                                request.getRequestDispatcher("editUserDetails.jsp").include(request, response);
                            }
                        }                                                
                    } catch (SQLException ex) {
                        session.setAttribute("updateErr", "Error: User was not updated successfully");
                        request.getRequestDispatcher("editUserDetails.jsp").include(request, response);
                    }
                }                                        
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }          
    }
}

