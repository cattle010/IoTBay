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
 * @author shuukinpuku
 */
public class DeleteProductServlet extends HttpServlet {

    @Override   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {
        HttpSession session = request.getSession();//1- retrieve the current session
        Validator validator = new Validator();//2- create an instance of the Validator class    
        int productID = Integer.parseInt(request.getParameter("pID"));  
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        ArrayList<Product> products;
        
        try{
            if(manager.checkProduct(productID))
                manager.deleteProduct(productID);
                products = manager.fetchProduct(); 
                session.setAttribute("products", products);
            request.getRequestDispatcher("viewproduct.jsp").include(request,response);
        }catch(SQLException | NullPointerException ex) {
                Logger.getLogger(DeleteProductServlet.class.getName()).log(Level.SEVERE, null, ex); 
        }
            
        
    }
}
