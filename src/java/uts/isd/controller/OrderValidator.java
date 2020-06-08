package uts.isd.controller;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
   import java.util.regex.Matcher;
   import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Kelvin Wang
 */
public class OrderValidator implements Serializable{ 
   private String orderIDPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";      
   private String userIDPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";       
   private String paymentIDPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";  
   private String shippingAddressIDPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)"; 
   private String orderDatePattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)"; 
   private String shipDatePattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)"; 
   private String orderStatusPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)"; 
              
   public OrderValidator(){    }       


   public boolean validate(String pattern, String input){       
      Pattern regEx = Pattern.compile(pattern);       
      Matcher match = regEx.matcher(input);       
      return match.matches(); 

   }       

   public boolean checkEmpty(String orderID, String userID){       

      return  orderID.isEmpty() || userID.isEmpty();   

   }

   
   public boolean validateorderID(String orderID){                       

      return validate(orderIDPattern,orderID);   

   }

       
   public boolean validateuserID(String userID){

      return validate(userIDPattern,userID); 

   }       
   

   public boolean validatepaymentID(String paymentID){

      return validate(paymentIDPattern,paymentID); 

   }   
   
   public boolean validateshippingAddressID(String shippingAddressID){

      return validate(shippingAddressIDPattern,shippingAddressID); 

   }    
   
   public boolean validateorderDate(String orderDate){

      return validate(orderDatePattern,orderDate); 

   }   
   
   public boolean validateshipDate(String shipDate){

      return validate(shipDatePattern,shipDate); 

   }  
   
   public boolean validateorderStatus(String orderStatus){

      return validate(orderStatusPattern,orderStatus); 

   }  

    void clear(HttpSession session) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
