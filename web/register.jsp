<%-- 
    Document   : register
    Created on : 30/05/2020, 1:43:02 AM
    Author     : jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="em" >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <%
            String existErr = (String) session.getAttribute("existErr");
            String emptyErr = (String) session.getAttribute("emptyErr");
            String firstNameErr = (String) session.getAttribute("firstNameErr");
            String lastNameErr = (String) session.getAttribute("lastNameErr");
            String passErr = (String) session.getAttribute("passwordErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String phoneErr = (String) session.getAttribute("phoneErr");            
        %>
        <title>Register</title>
    </head>
    <body>
        <div class="container">
            <h1>Register</h1>
            <p><%=(existErr != null ? existErr : "")%></p>            
            <form method="post" action="RegisterServlet">
                <div class="form-row">
                    <div class="form-group col">
                        <label for="firstName">First Name</label>                        
                        <input name="firstName" type="text" class="form-control" placeholder="<%=(firstNameErr != null ? firstNameErr : "Enter first name...")%>" required>
                    </div>
                    <div class="form-group col">
                        <label for="lastName">Last Name</label>
                        
                        <input name="lastName" type="text" class="form-control" placeholder="<%=(lastNameErr != null ? lastNameErr : "Enter last name...")%>" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="email">Email Address</label>                    
                    <input name="email"type="email" class="form-control" placeholder="<%=(emailErr != null ? emailErr : "Enter email..")%>" required>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>                    
                    <input name="password" type="password" class="form-control" placeholder="<%=(passErr != null ? passErr : "Enter password...")%>" required>
                </div>                
                <div class="form-group">
                    <label for="phonenumber">Phone number (Optional)</label>                    
                    <input name="phoneNumber" type="text" class="form-control" placeholder="<%=(phoneErr != null ? phoneErr : "Enter phone number here...")%>">
                </div>
                <div class="form-group">
                    <a class="form-text text-muted" href="login.jsp">Already have an account? Log in here!</a>
                </div>
                <div class="form-row">
                    <div class="form-group col">
                        <a href="index.jsp"><button type="button" class="btn btn-secondary btn-lg btn-block">Back</button></a>
                    </div>
                    <div class="form-group col">
                        <button class="btn btn-primary btn-lg btn-block" type="submit">Register</button>                
                    </div>
                </div>
            </form>
        </div>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
