/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class EditProductServlet extends HttpServlet {
    
    @Override   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
        HttpSession session = request.getSession();//1- retrieve the current session
        Validator validator = new Validator();//2- create an instance of the Validator class    
        int productID = Integer.parseInt(request.getParameter("pID"));  
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        Product editproduct;
        ArrayList<Product> products;
        
        try{
                editproduct = manager.findProduct(productID);
                session.setAttribute("editproduct",editproduct);      //8-set incorrect email error to the session           
                request.getRequestDispatcher("updateproduct.jsp").include(request,response);
                products = manager.fetchProduct(); 
                session.setAttribute("products", products);
                session.setAttribute("updateMess","Update successfully");
        }
        catch (SQLException | NullPointerException ex) {
                Logger.getLogger(EditProductServlet.class.getName()).log(Level.SEVERE, null, ex); 
        }
        

        
    }

}
