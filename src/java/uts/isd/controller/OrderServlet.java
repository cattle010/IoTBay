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
       private DBConnector db;

       private OrderDAO orderdao;

       private Connection conn;
       @Override

       public void init() {

           try {

               db = new DBConnector();

           } catch (ClassNotFoundException | SQLException ex) {
               Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
           }      

       }
       @Override
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           response.setContentType("text/html;charset=UTF-8");       
           HttpSession session = request.getSession();
           OrderDAO OrderDAO = (OrderDAO) session.getAttribute("orderdao");
           conn = db.openConnection();       
           try {
               orderdao = new OrderDAO(conn);
           } catch (SQLException ex) {
               Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
           session.setAttribute("orderdao", orderdao);           
       }
       @Override
        public void destroy() {
           try {
               db.closeConnection();
           } catch (SQLException ex) {
               Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
        
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        int orderID = Integer.parseInt(request.getParameter("orderid"));
        int userID = Integer.parseInt(request.getParameter("userid"));
        int paymentID = Integer.parseInt(request.getParameter("paymentid"));
        int shippingAddressID = Integer.parseInt(request.getParameter("shippingaddressid"));
        OrderDAO OrderDAO = (OrderDAO) session.getAttribute("orderDAO");
        Order order = null;
        validator.clear(session);      
        
        try {         
            order = OrderDAO.findOrder(orderID);
        } 
        catch (SQLException ex) {           
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);       
        }
        }
   }
