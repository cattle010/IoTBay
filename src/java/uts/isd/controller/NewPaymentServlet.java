/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date; 
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
            HttpSession session = request.getSession();
            PaymentDAO paymentDAO = (PaymentDAO) session.getAttribute("paymentDAO");
            String PaymentName = request.getParameter("PaymentName");
            String PaymentStatus = request.getParameter("PaymentStatus");
            double PaymentAmount = Double.parseDouble(request.getParameter("PaymentAmount"));
            Date PaymentDate = Date.valueOf(request.getParameter("PaymentDate"));
            String PaymentMethod = request.getParameter("PaymentMethod");
            String CardFName = request.getParameter("CardFName");
            String CardLName = request.getParameter("CardLName");
            int CardNumber = Integer.parseInt(request.getParameter("CardNumber"));
            Date CardValid = Date.valueOf(request.getParameter("CardValid"));
            Date CardExpire = Date.valueOf(request.getParameter("CardExpire"));
            int CardSecurityNum = Integer.parseInt(request.getParameter("CardSecurityNum"));     
            try {
                paymentDAO.addPayment(PaymentName, PaymentStatus, PaymentAmount, PaymentDate, PaymentMethod, CardFName, CardLName, CardNumber, CardValid, CardExpire, CardSecurityNum);
                response.sendRedirect("PaymentServlet");
            } catch (SQLException e){
               throw new ServletException("Cannot add payment to Database", e); 
            }
        }
}