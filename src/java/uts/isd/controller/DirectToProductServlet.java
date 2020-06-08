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
public class DirectToProductServlet extends HttpServlet {
    
    @Override   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
        HttpSession session = request.getSession();//1- retrieve the current session
        Validator validator = new Validator();//2- create an instance of the Validator class    
        boolean isStaff = Boolean.parseBoolean(request.getParameter("isStaff")); 
        boolean isRegisteredUser = Boolean.parseBoolean(request.getParameter("isRegisteredUser"));
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        ArrayList<Product> products;
         
        
        try{
                products = manager.fetchProduct(); 
                if(!isStaff && isRegisteredUser){
                    session.setAttribute("products", products);              
                    request.getRequestDispatcher("userviewproduct.jsp").include(request,response);
                }else if(!isStaff && !isRegisteredUser){
                    session.setAttribute("products", products);               
                    request.getRequestDispatcher("userviewproduct.jsp").include(request,response);
                }else if(isStaff){
                    session.setAttribute("products", products);          
                    request.getRequestDispatcher("viewproduct.jsp").include(request,response);
                }
                
        }
        catch (SQLException | NullPointerException ex) {
                Logger.getLogger(EditProductServlet.class.getName()).log(Level.SEVERE, null, ex); 
        }
        

        
    }

}
