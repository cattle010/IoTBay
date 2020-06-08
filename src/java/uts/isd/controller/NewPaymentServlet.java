/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Payment;
import uts.isd.model.dao.PaymentDAO;

/**
 *
 * @author mamoo
 */
@WebServlet(name = "NewPaymentServlet", urlPatterns = {"/NewPaymentServlet"})
public class NewPaymentServlet extends HttpServlet {
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
            HttpSession session = request.getSession();
            PaymentDAO pd = (PaymentDAO) session.getAttribute("pd");
            try {
                ArrayList<Payment> payments = pd.fetchPayments();
                request.setAttribute("payments", payments);
                request.getRequestDispatcher("payment.jsp").include(request, response);
            } catch (SQLException e){
               throw new ServletException("Cannot obtain payments from Database", e); 
            }
        }
}
