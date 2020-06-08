<%-- 
    Document   : logout
    Created on : 04/06/2020, 12:30:17 AM
    Author     : jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <title>Logout</title>
    </head>
    <body>        
        <div class="container">
            <h1 class="text-center">Logout</h1>
            <p class="text-center">You have been logged out.</p>
            <p class="text-center">Return to the main page below.</p>
            <div class="text-center">
                <a href="index.jsp"><button type="button" class="btn btn-secondary">Home Page</button></a>
            </div>            
        </div>                
        <jsp:include page="/LogoutServlet" flush="true" />
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
