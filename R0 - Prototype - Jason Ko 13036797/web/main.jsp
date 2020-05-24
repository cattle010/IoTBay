<%-- 
    Document   : main
    Created on : 29/04/2020, 9:33:05 PM
    Author     : jason
--%>

<%@page import="uts.isd.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
        <%
            Customer customer = (Customer)session.getAttribute("customer");
        %>
    </head>
    <body>
        <% if (customer.getName() != null) { %>
            <h1>Your Account Information</h1>
            <p>You are signed in as: ${customer.name}</p>            
        <% } else { %>
            <h1>Your Account Information</h1>
            <p>You are signed in as: ${customer.email}</p>            
        <% } %>
        <a href="logout.jsp"><button type="button">Logout</button></a>
    </body>
</html>
