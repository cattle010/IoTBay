/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.PaymentDAO;

/**
 *
 * @author mamoo
 */
@WebServlet(name = "DeletePaymentServlet", urlPatterns = {"/DeletePaymentServlet"})
public class DeletePaymentServlet extends HttpServlet {
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
            HttpSession session = request.getSession();
            PaymentDAO paymentDAO = (PaymentDAO) session.getAttribute("paymentDAO");
            int payment = Integer.parseInt(request.getParameter("PaymentID"));
            try {
                paymentDAO.deletePayment(payment);
                response.sendRedirect("NewPaymentServlet");
            } catch(SQLException e){
               throw new ServletException("Cannot add payment to Database", e); 
            }
        }
}

