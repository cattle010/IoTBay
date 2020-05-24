<%-- 
    Document   : welcome
    Created on : 29/04/2020, 9:19:11 PM
    Author     : jason
--%>

<%@page import="uts.isd.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        <%
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            //String referer = request.getHeader("referer");
        %>
    </head>
    <body>
        <% if (name != null) { %>
            <h1>Welcome <%= name %>!</h1>
            <p>Welcome to the IoT Bay Marketplace</p>
            <p>The email you have provided is: <%= email %></p>
        <% } else { %>
            <h1>Welcome back!</h1>
            <p>You are signed in with the email: <%= email %></p>
        <% } %>
        <p>Please proceed to the main page</p>
        <a href="main.jsp"><button type="button">Main Page</button></a>
    </body>
        <%
            Customer customer = new Customer(name, email, password);
            session.setAttribute("customer", customer);            
        %>
</html>
