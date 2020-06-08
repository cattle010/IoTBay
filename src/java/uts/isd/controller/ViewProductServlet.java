/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.*;
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
 * @author Xuanhao Zhou
 */
public class ViewProductServlet extends HttpServlet {

   @Override   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
        HttpSession session = request.getSession();//1- retrieve the current session
        Validator validator = new Validator();//2- create an instance of the Validator class   
        DBManager manager = (DBManager) session.getAttribute("manager");//5- retrieve the manager instance from session      
           
        ArrayList<Product> products;
           
           try {       
                    products = manager.fetchProduct(); 
                    session.setAttribute("products", products);//13-save the logged in user object to the session
                    request.getRequestDispatcher("viewproduct.jsp").forward(request,response);
            }catch (SQLException | NullPointerException ex) {
                    Logger.getLogger(ViewProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }
    
    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
        doGet(request, response);
    }
 }