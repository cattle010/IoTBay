/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;
/**
 *
 * @author jason
 */
public class Validator implements Serializable{ 
   private String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";      
   //private String namePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";       
   private String namePattern = "([A-Za-z]+)";       
   private String passwordPattern = "[A-Za-z0-9]{4,}";
   private String phonePattern = "([0-9]{10,})";
              
   public Validator() {    
       //empty
   }       
   public boolean validate(String pattern, String input){       
      Pattern regEx = Pattern.compile(pattern);       
      Matcher match = regEx.matcher(input);       
      return match.matches(); 
   }       

   public boolean checkEmpty(String email, String password){       
      return  email.isEmpty() || password.isEmpty();   
   }
   
   public boolean checkRegisterEmpty(String firstName, String lastName, String email, String password, String phoneNumber){       
      return  firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || phoneNumber.isEmpty();   
   }
   
   public boolean validateEmail(String email){                       
      return validate(emailPattern,email);   
   }
     
   public boolean validateName(String name){
      return validate(namePattern,name); 
   }       
   
   public boolean validatePassword(String password){
      return validate(passwordPattern,password); 
   }
   
   public boolean validatePhoneNumber(String phoneNumber) {
       return validate(phonePattern, phoneNumber);
   }
   
   public void clear(HttpSession session) {
       session.setAttribute("emailErr", "Enter email");
       session.setAttribute("passErr", "Enter password");
       session.setAttribute("existErr", "");
       session.setAttribute("phoneErr", "Please enter phone number");
       session.setAttribute("emptyErr", "Please fill in the required fields");
       session.setAttribute("addErr", "User not added to system");
   }
}