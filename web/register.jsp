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
        <title>Register</title>
    </head>
    <body>
        <div class="container">
            <h1>Register</h1>
            <form method="post">
                <div class="form-row">
                    <div class="form-group col">
                        <label for="firstName">First Name</label>
                        <input type="text" class="form-control" placeholder="Enter first name here...">
                    </div>
                    <div class="form-group col">
                        <label for="lastName">Last Name</label>
                        <input type="text" class="form-control" placeholder="Enter last name here...">
                    </div>
                </div>
                <div class="form-group">
                    <label for="email">Email Address</label>
                    <input type="email" class="form-control" placeholder="Enter email here...">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control">
                </div>                
                <div class="form-group">
                    <label for="phonenumber">Phone number (Optional)</label>
                    <input type="text" class="form-control" placeholder="9999 999 999">
                </div>
                <div class="form-group">
                    <a class="form-text text-muted" href="login.jsp">Already have an account? Log in here!</a>
                </div>
                <div class="form-row">
                    <div class="form-group col">
                        <a href="index.jsp"><button type="button" href="index.jsp" class="btn btn-secondary btn-lg btn-block">Back</button></a>
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
