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
            String addErr = (String) session.getAttribute("addErr");
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
            <p class="text-danger"><%=(existErr != null ? existErr : "")%></p>            
            <p class="text-danger"><%=(addErr != null ? addErr : "")%></p>            
            <form method="post" action="RegisterServlet">
                <div class="form-row">
                    <div class="form-group col">
                        <label for="firstName">First Name<span class="text-danger"> *</span></label>
                        <small class="text-danger"><%=(firstNameErr != null ? firstNameErr : "")%></small>
                        <input name="firstName" type="text" class="form-control" placeholder="Enter first name..." required>
                        <small class="text-muted">Only alphabetical and special characters like . ' - allowed</small>
                    </div>
                    <div class="form-group col">
                        <label for="lastName">Last Name<span class="text-danger"> *</span></label>                        
                        <small class="text-danger"><%=(lastNameErr != null ? lastNameErr : "")%></small>
                        <input name="lastName" type="text" class="form-control" placeholder="Enter last name..." required>                        
                    </div>
                </div>
                <div class="form-group">
                    <label for="email">Email Address<span class="text-danger"> *</span></label>  
                    <small class="text-danger"><%=(emailErr != null ? emailErr : "")%></small>
                    <input name="email"type="email" class="form-control" placeholder="Enter email.." required>
                    <small class="text-muted">Your email can contain letters, numbers and special characters like . _ -</small>
                </div>
                <div class="form-group">
                    <label for="password">Password<span class="text-danger"> *</span></label>     
                    <small class="text-danger"><%=(passErr != null ? passErr : "")%></small>
                    <input name="password" type="password" class="form-control" placeholder="Enter password..." required>
                    <small class="text-muted">Your password must be between 4 - 100 characters and can only contain numbers, uppercase and lowercase letters</small>
                </div>                
                <div class="form-group">
                    <label for="phonenumber">Phone number (Optional)</label>    
                    <small class="text-danger"><%=(phoneErr != null ? phoneErr : "")%></small>
                    <input name="phoneNumber" type="text" class="form-control" placeholder="Enter phone number here...">
                    <small class="text-muted">Your phone number must be exactly 10 digits long and can only contain numbers</small>
                </div>
                <div class="form-group">
                    <a class="form-text text-info" href="login.jsp">Already have an account? Log in here!</a>
                    <p class="text-danger">* Required</p>
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
