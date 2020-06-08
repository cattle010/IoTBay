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
<<<<<<< HEAD
        <%
            String existErr = (String) session.getAttribute("existErr");;
            String firstNameErr = (String) session.getAttribute("firstNameErr");
            String lastNameErr = (String) session.getAttribute("lastNameErr");      
        %>
=======
>>>>>>> 9bbc81bc458fa988010876709388779cb3d8ea7e
        <title>New Payment</title>    
    </head>
    <body>
        <div class="container">
            <h1>New Payment</h1>
<<<<<<< HEAD
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
=======
            <form method="post" action="newPaymentServlet">
                <div class="form-group">
                    <label for="paymentMethod">Payment Method<span class="text-danger"> *</span></label>  
                    <input name="paymentMethod"list="paymentMethod" class="form-control" placeholder="Select one of the following" required>
                    <datalist id="paymentmethod">
                        <option value="Debit Card">
                        <option value="Credit Card">
                        <option value="Prepaid Card">
                    </datalist>
                    <small class="text-muted">Select your preferred payment method</small>
                </div>
>>>>>>> 9bbc81bc458fa988010876709388779cb3d8ea7e
                <h2>Enter card details below:</h2>
                
                <div class="form-row">
                    <div class="form-group col">
<<<<<<< HEAD
                        <label for="CardFName">First Name<span class="text-danger"> *</span></label>
                        <small class="text-danger"><%=(firstNameErr != null ? firstNameErr : "")%></small>
                        <input name="CardFName" type="text" class="form-control" placeholder="Enter First Name on Card..." required>
                        <small class="text-muted">Enter First Name on Card</small>
                    </div>
                    <div class="form-group col">
                        <label for="CardLName">Last Name<span class="text-danger"> *</span></label>                        
                        <small class="text-danger"><%=(lastNameErr != null ? lastNameErr : "")%></small>
                        <input name="CardLName" type="text" class="form-control" placeholder="Enter Last Name on Card..." required>      
=======
                        <label for="cardFName">First Name<span class="text-danger"> *</span></label>
                        <input name="cardFName" type="text" class="form-control" placeholder="Enter First Name on Card..." required>
                        <small class="text-muted">Enter First Name on Card</small>
                    </div>
                    <div class="form-group col">
                        <label for="cardLName">Last Name<span class="text-danger"> *</span></label>
                        <input name="cardLName" type="text" class="form-control" placeholder="Enter Last Name on Card..." required>      
>>>>>>> 9bbc81bc458fa988010876709388779cb3d8ea7e
                         <small class="text-muted">Enter Last Name on Card</small>
                    </div>
                </div> 
                
                <div class="form-group">
<<<<<<< HEAD
                    <label for="CardNumber">Card Number<span class="text-danger"> *</span></label>  
                    <input name="CardNumber" type="number" class="form-control" placeholder="Enter Card Number..." required>
=======
                    <label for="cardNumber">Card Number<span class="text-danger"> *</span></label>  
                    <input name="cardNumber" type="number" class="form-control" placeholder="Enter Card Number..." required>
>>>>>>> 9bbc81bc458fa988010876709388779cb3d8ea7e
                    <small class="text-muted">Enter the 16 digit number on the front of your card</small>
                </div>
                
                 <div class="form-row">
                    <div class="form-group col">
<<<<<<< HEAD
                        <label for="CardValid">Valid From Date<span class="text-danger"> *</span></label>
                        <input name="CardValid" type="date" class="form-control" placeholder="Enter in format mm/yyyy" required>
                        <small class="text-muted">Enter the Valid from date found on the front of the card</small>
                    </div>
                    <div class="form-group col">
                        <label for="CardExpire">Expiry Date<span class="text-danger"> *</span></label>
                        <input name="CardExpire" type="date" class="form-control" placeholder="Enter in format mm/yyyy" required>
=======
                        <label for="cardValid">Valid From Date<span class="text-danger"> *</span></label>
                        <input name="cardValid" type="date" class="form-control" placeholder="Enter in format mm/yyyy" required>
                        <small class="text-muted">Enter the Valid from date found on the front of the card</small>
                    </div>
                    <div class="form-group col">
                        <label for="cardExpire">Expiry Date<span class="text-danger"> *</span></label>
                        <input name="cardExpire" type="date" class="form-control" placeholder="Enter in format mm/yyyy" required>
>>>>>>> 9bbc81bc458fa988010876709388779cb3d8ea7e
                        <small class="text-muted">Enter the card's expiry date found on the front of the card</small>                        
                    </div>
                </div>
                
                <div class="form-group">
<<<<<<< HEAD
                    <label for="CardSecurityNum">Security Code<span class="text-danger"> *</span></label>  
                    <input name="CardSecurityNum" type="number" class="form-control" placeholder="Enter the Security Code..." required>
=======
                    <label for="cardSecurityNum">Security Code<span class="text-danger"> *</span></label>  
                    <input name="cardSecurityNum" type="number" class="form-control" placeholder="Enter the Security Code..." required>
>>>>>>> 9bbc81bc458fa988010876709388779cb3d8ea7e
                    <small class="text-muted">Enter the 3 digit code on the back of your card</small>
                </div>
                
                <h2>Confirm Payment Details:</h2>
                <div class="form-group">
<<<<<<< HEAD
                    <label for="PaymentAmount">Payment Amount<span class="text-danger"> *</span></label>  
                    <input name="PaymentAmount" type="number" class="form-control" placeholder="Enter the Amount to be Paid..." required>
                    <small class="text-muted">Enter the Amount to be Paid...</small>
                </div>
                <div class="form-group">
                    <label for="PaymentDate">Payment Date<span class="text-danger"> *</span></label>  
                    <input name="PaymentDate" type="date" class="form-control" placeholder="Enter the date to paid..." required>
=======
                    <label for="paymentAmount">Payment Amount<span class="text-danger"> *</span></label>  
                    <input name="paymentAmount" type="number" class="form-control" placeholder="Enter the Amount to be Paid..." required>
                    <small class="text-muted">Enter the Amount to be Paid...</small>
                </div>
                <div class="form-group">
                    <label for="paymentDate">Payment Date<span class="text-danger"> *</span></label>  
                    <input name="paymentDate" type="date" class="form-control" placeholder="Enter the date to paid..." required>
>>>>>>> 9bbc81bc458fa988010876709388779cb3d8ea7e
                    <small class="text-muted">Enter the date to paid...</small>
                </div>
                <div class="form-row">
                    <div class="form-group col">
                        <a href="viewPayment.jsp"><button type="button" class="btn btn-secondary btn-lg btn-block">Save Payment</button></a>
                    </div>
                    <div class="form-group col">
<<<<<<< HEAD
                        <a href="viewPayment.jspv"><button class="btn btn-primary btn-lg btn-block" type="submit">Pay Now</button></a>                
=======
                        <a href="paymentSuccess.jsp"><button class="btn btn-primary btn-lg btn-block" type="submit">Pay Now</button></a>                
>>>>>>> 9bbc81bc458fa988010876709388779cb3d8ea7e
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
