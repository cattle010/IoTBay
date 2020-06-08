/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "EditPaymentServlet", urlPatterns = {"/EditPaymentServlet"})
public class EditPaymentServlet extends HttpServlet {
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
        }
    
}
