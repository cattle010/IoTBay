/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
public class UpdateServlet extends HttpServlet {

    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
        HttpSession session = request.getSession();//1- retrieve the current session
        Validator validator = new Validator();//2- create an instance of the Validator class    
        int productID = Integer.parseInt(request.getParameter("proID"));  
        String productName = request.getParameter("proName");
        String brandName = request.getParameter("bName");//4- capture the posted password    
        String description  = request.getParameter("desc");
        Double cpu = Double.parseDouble(request.getParameter("cpu"));
        int stock = Integer.parseInt(request.getParameter("s"));
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        Product newProduct;
        ArrayList<Product> products;
        
        try{
            manager.updateProduct(productID,productName,brandName,description,cpu,stock);
            request.getRequestDispatcher("update.jsp").include(request,response);
            products = manager.fetchProduct(); 
            session.setAttribute("products", products);
        }
        catch (SQLException | NullPointerException ex) {
                Logger.getLogger(AddServlet.class.getName()).log(Level.SEVERE, null, ex); 
        }
        

        
    }
}
