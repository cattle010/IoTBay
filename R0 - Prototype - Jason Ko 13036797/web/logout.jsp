<%-- 
    Document   : logout
    Created on : 29/04/2020, 9:53:08 PM
    Author     : jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <h1>Logout</h1>
        <p>You have been logged out. Click <a href="index.jsp">here</a> to return to the home page.</p>
        <%
            session.invalidate();
        %>
    </body>
</html>
