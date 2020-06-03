<%-- 
    Document   : login.jsp
    Created on : 31/05/2020, 7:57:33 PM
    Author     : jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">  
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <title>Login</title>
        
        <%            
            String existErr = (String) session.getAttribute("existErr");
            String passErr = (String) session.getAttribute("passErr");
            String emailErr = (String) session.getAttribute("emailErr");
        %>
    </head>
    <body>
        <div class="container">
        <h1>Login</h1>
        <div class="invalid-feedback"><%= (existErr != null ? existErr : "User does not exist in the database")%></div>
        <form method="post" action="LoginServlet">
            <div class="form-group">
                <label for="email">Email Address</label>
                <input name="email" type="email" class="form-control" placeholder="<%= (emailErr != null ? emailErr : "Enter email")%>" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input name="password" type="password" placeholder="<%= (passErr != null ? passErr : "Enter password")%>" class="form-control" required>
            </div>
            <div class="form-group">
                <a class="form-text text-muted" href="register.jsp">Haven't made an account yet? Register here!</a>
            </div>
            <div class="form-row">
                <div class="form-group col">
                    <a href="index.jsp"><button type="button" class="btn btn-secondary btn-lg btn-block">Back</button></a>
                </div>
                <div class="form-group col">
                    <button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>                
                </div>
            </div>
        </form>
        </div>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
