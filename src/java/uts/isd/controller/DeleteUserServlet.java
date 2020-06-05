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
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        HttpSession session = request.getSession();       
        Validator validator = new Validator();                
        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");        
        User user = null;
        User userToDelete = (User) session.getAttribute("user");
        int userID = userToDelete.getUserID();
        validator.clear(session);
                
        if (userToDelete != null) {
            try {
                userDAO.deleteUser(userID);
                session.invalidate();
                response.sendRedirect("index.jsp");
            } catch (SQLException ex) {
                Logger.getLogger(DeleteUserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            session.setAttribute("userExistErr", "Error: User does not exist");
            request.getRequestDispatcher("deleteUser.jsp").include(request, response);
        }        
    }                 
}
