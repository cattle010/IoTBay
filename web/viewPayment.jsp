<%-- 
    Document   : viewPayment
    Created on : 01/06/2020, 4:09:10 PM
    Author     : mamoo
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <title>View Payment</title>
    </head>
    <body>
        <h1>View Payment</h1>
        <p>View payments here</p>
        <%
    ArrayList<Payment> payments = (ArrayList<Payment>)request.getAttribute("payments");
%>  
<!--sidebar-menu-->
    <div class="widget-content nopadding">
     <table class="table table-bordered table-striped">
       <thead>
         <tr>
           <th>Payment ID</th>
           <th>Payment Name</th>
           <th>Payment Amount</th>
           <th>Payment Date</th>
         </tr>
       </thead>

     </table>
      <jsp:include page="/NewPaymentServer" flush="true" />
    </body>
</html>
