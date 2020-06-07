 package uts.isd.controller;

 /**
 *
 * @author Kelvin Wang
 */

   import java.io.IOException;
   import java.sql.Connection;
   import java.sql.SQLException;
   import java.util.logging.Level;
   import java.util.logging.Logger;
   import javax.servlet.ServletException;
   import javax.servlet.http.HttpServlet;
   import javax.servlet.http.HttpServletRequest;
   import javax.servlet.http.HttpServletResponse;
   import javax.servlet.http.HttpSession;
import uts.isd.model.Order;
   import uts.isd.model.dao.*;

   public class OrderServlet extends HttpServlet {
       private OrderDBConnector db;

       private OrderDBManager manager;

       private Connection conn;
       @Override

       public void init() {

           try {

               db = new OrderDBConnector();

           } catch (ClassNotFoundException | SQLException ex) {
               Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
           }      

       }
       @Override
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           response.setContentType("text/html;charset=UTF-8");       
           HttpSession session = request.getSession();
           conn = db.openConnection();       
           try {
               manager = new OrderDBManager(conn);
           } catch (SQLException ex) {
               Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
           session.setAttribute("ordermanager", manager);           
       }
       @Override
        public void destroy() {
           try {
               db.closeConnection();
           } catch (SQLException ex) {
               Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
   }
