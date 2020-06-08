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
public class AddProductServlet extends HttpServlet {

   @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
        HttpSession session = request.getSession();//1- retrieve the current session
        Validator validator = new Validator();//2- create an instance of the Validator class    
        int productID = Integer.parseInt(request.getParameter("productID"));  
        String productName = request.getParameter("productName");
        String brandName = request.getParameter("brandName");//4- capture the posted password    
        String description  = request.getParameter("description");
        Double cpu = Double.parseDouble(request.getParameter("costPerUnit"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        Product newProduct;
        ArrayList<Product> products;
        
        try{
            if(manager.checkProduct(productID)){
                session.setAttribute("existErr", "Error:this product ID already exist");      //8-set incorrect email error to the session           
                request.getRequestDispatcher("addproduct.jsp").include(request,response);
            }else{
                manager.addProduct(productID,productName,brandName,description,cpu,stock);
                request.getRequestDispatcher("addproduct.jsp").include(request,response);
                session.setAttribute("addSucc", "Add product successfully");
                products = manager.fetchProduct(); 
                session.setAttribute("products", products);
            }
        }
        catch (SQLException | NullPointerException ex) {
                Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex); 
        }
        

        
    }
}