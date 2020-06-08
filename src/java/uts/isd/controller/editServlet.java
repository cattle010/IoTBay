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
import uts.isd.model.User;
import uts.isd.model.dao.UserDAO;

/**
 *
 * @author xun.s.chang
 */
@WebServlet("/editServlet")
public class editServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        validator.clear(session);
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
        String userEmail = request.getParameter("useremail");
        try {
            User editUser = userDAO.findUser(userEmail);
            request.setAttribute("editUser", editUser);
        } catch (SQLException ex) {
            Logger.getLogger(editServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("adminEditUserDetails.jsp").include(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        HttpSession session = request.getSession();               
        String firstName = request.getParameter("firstName").trim();
        String lastName = request.getParameter("lastName").trim();
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();
        String phoneNumber = request.getParameter("phoneNumber").trim();
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
        int userID = Integer.parseInt(request.getParameter("userid"));

        
        try {
           
            userDAO.updateUser(userID, email, firstName, lastName, password, phoneNumber);
            response.sendRedirect("ListUserServlet");
                         
        } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }
}

