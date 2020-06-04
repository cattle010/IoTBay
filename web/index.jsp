<%-- 
    Document   : index
    Created on : 24/05/2020, 3:10:57 PM
    Author     : jason
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <title>IoTBay Online Storefront</title>
        <%
            User user = (User) session.getAttribute("user");
        %>    
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">IoTBay</h1>            
            <% if (user != null) { %>
                <nav class="nav justify-content-center">
                    <a class="nav-link nav-item active" href="account.jsp">Account</a>                    
                    <a class="nav-link nav-item active" href="logout.jsp">Logout</a>
                </nav>
                <p>Hello there ${user.userEmail}</p>
            <% } else { %>
                <nav class="nav justify-content-center">
                    <a class="nav-link nav-item active" href="register.jsp">Register</a>
                    <a class="nav-link nav-item active" href="login.jsp">Login</a>
                </nav>
            <% } %>
        </div>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>
