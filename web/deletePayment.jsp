<%-- 
    Document   : deletePayment
    Created on : 01/06/2020, 4:08:59 PM
    Author     : mamoo
--%>
<%@page import="uts.isd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <title>Delete Payment</title>
    </head>
    <body>
        <div class="container text-center">
            <h1>Delete Payment</h1>
            <p>Are you sure you want to delete this payment?</p>
            <p>All data associated with this payment will be deleted.</p>
            <form method="post" action="DeletePaymentServlet">
                <div class="form-row justify-content-center">
                    <div class="form-group col-3">
                        <a href="viewPayment.jsp"><button type="button" class="btn btn-secondary btn-block">Back</button></a>
                    </div>
                    <div class="form-group col-3">
                        <button class="btn btn-danger btn-block" type="submit">Delete Payment</button>                
                    </div>
                </div>
            </form>
        </div>        
    </body>
</html>
