<%-- 
    Document   : newPayment
    Created on : 01/06/2020, 4:08:07 PM
    Author     : mamoo
--%>
<%@page import="uts.isd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <%
            String existErr = (String) session.getAttribute("existErr");;
            String firstNameErr = (String) session.getAttribute("firstNameErr");
            String lastNameErr = (String) session.getAttribute("lastNameErr");      
        %>
        <title>New Payment</title>    
    </head>
    <body>
        <div class="container">
            <h1>New Payment</h1>
            <form method="post" action="NewPaymentServlet">
                <div class="form-group">
                    <label for="PaymentMethod">Payment Method<span class="text-danger"> *</span></label>  
                    <select id="paymentmethod" name="paymentMethod" class="form-control" placeholder="Select one of the following" required >
                        <option value="Debit Card">Debit Card</option>
                        <option value="Credit Card">Credit Card</option>
                        <option value="Prepaid Card">Master Card</option>
                        <option value="Prepaid Card">Visa Card</option>
                    </select>
                    <small class="text-muted">Select your preferred payment method</small>
                </div>
                <div class="form-group">
                    <label for="PaymentName">Payment Method<span class="text-danger"> *</span></label>
                    <input name="PaymentName" type="text" class="form-control" placeholder="Enter Transacaction Name..." required>
                    <small class="text-muted">Name your transaction</small>
                </div>
                <h2>Enter card details below:</h2>
                
                <div class="form-row">
                    <div class="form-group col">
                        <label for="CardFName">First Name<span class="text-danger"> *</span></label>
                        <small class="text-danger"><%=(firstNameErr != null ? firstNameErr : "")%></small>
                        <input name="CardFName" type="text" class="form-control" placeholder="Enter First Name on Card..." required>
                        <small class="text-muted">Enter First Name on Card</small>
                    </div>
                    <div class="form-group col">
                        <label for="CardLName">Last Name<span class="text-danger"> *</span></label>                        
                        <small class="text-danger"><%=(lastNameErr != null ? lastNameErr : "")%></small>
                        <input name="CardLName" type="text" class="form-control" placeholder="Enter Last Name on Card..." required>      
                         <small class="text-muted">Enter Last Name on Card</small>
                    </div>
                </div> 
                
                <div class="form-group">
                    <label for="CardNumber">Card Number<span class="text-danger"> *</span></label>  
                    <input name="CardNumber" type="number" class="form-control" placeholder="Enter Card Number..." required>
                    <small class="text-muted">Enter the 16 digit number on the front of your card</small>
                </div>
                
                 <div class="form-row">
                    <div class="form-group col">
                        <label for="CardValid">Valid From Date<span class="text-danger"> *</span></label>
                        <input name="CardValid" type="date" class="form-control" placeholder="Enter in format mm/yyyy" required>
                        <small class="text-muted">Enter the Valid from date found on the front of the card</small>
                    </div>
                    <div class="form-group col">
                        <label for="CardExpire">Expiry Date<span class="text-danger"> *</span></label>
                        <input name="CardExpire" type="date" class="form-control" placeholder="Enter in format mm/yyyy" required>
                        <small class="text-muted">Enter the card's expiry date found on the front of the card</small>                        
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="CardSecurityNum">Security Code<span class="text-danger"> *</span></label>  
                    <input name="CardSecurityNum" type="number" class="form-control" placeholder="Enter the Security Code..." required>
                    <small class="text-muted">Enter the 3 digit code on the back of your card</small>
                </div>
                
                <h2>Confirm Payment Details:</h2>
                <div class="form-group">
                    <label for="PaymentAmount">Payment Amount<span class="text-danger"> *</span></label>  
                    <input name="PaymentAmount" type="number" class="form-control" placeholder="Enter the Amount to be Paid..." required>
                    <small class="text-muted">Enter the Amount to be Paid...</small>
                </div>
                <div class="form-group">
                    <label for="PaymentDate">Payment Date<span class="text-danger"> *</span></label>  
                    <input name="PaymentDate" type="date" class="form-control" placeholder="Enter the date to paid..." required>
                    <small class="text-muted">Enter the date to paid...</small>
                </div>
                <div class="form-row">
                    <div class="form-group col">
                        <a href="viewPayment.jsp"><button type="button" class="btn btn-secondary btn-lg btn-block">Save Payment</button></a>
                    </div>
                    <div class="form-group col">
                        <a href="viewPayment.jspv"><button class="btn btn-primary btn-lg btn-block" type="submit">Pay Now</button></a>                
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
