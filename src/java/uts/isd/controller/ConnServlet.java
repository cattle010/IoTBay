package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uts.isd.model.dao.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import uts.isd.model.Product;

/**
 *
 * @author Xuanhao Zhou
 */

public class ConnServlet extends HttpServlet {

    private DBConnector db;
    private DBManager manager;
    private Connection conn; 

       @Override //Create and instance of DBConnector for the deployment session
       public void init() {
           try {
               db = new DBConnector();
           } catch (ClassNotFoundException | SQLException ex) {
               Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
           }      
       }


       @Override //Add the DBConnector, DBManager, Connection instances to the session
       protected void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
           response.setContentType("text/html;charset=UTF-8");       
           HttpSession session = request.getSession();
           conn = db.openConnection();       
           try {
               manager = new DBManager(conn);
           } catch (SQLException ex) {
               Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
           //export the DB manager to the view-session (JSPs)
           session.setAttribute("manager", manager);          
           
          ArrayList<Product> products;
           
           try {       
                    products = manager.fetchProduct(); 
                    session.setAttribute("products", products);//13-save the logged in user object to the session
                    request.getRequestDispatcher("viewproduct.jsp").forward(request,response);
            }catch (SQLException | NullPointerException ex) {
                    Logger.getLogger(ViewProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
       }   


       @Override //Destroy the servlet and release the resources of the application (terminate also the db connection)
        public void destroy() {
           try {
               db.closeConnection();
           } catch (SQLException ex) {
               Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
           }

       }

}
