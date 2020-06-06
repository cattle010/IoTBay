<%-- 
    Document   : editUserDetails
    Created on : 04/06/2020, 3:59:15 PM
    Author     : jason
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <title>Edit User Details</title>        
        <%
            User user = (User) session.getAttribute("user");
            String firstNameErr = (String) session.getAttribute("firstNameErr");
            String lastNameErr = (String) session.getAttribute("lastNameErr");
            String passErr = (String) session.getAttribute("passErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String phoneErr = (String) session.getAttribute("phoneErr");
            String emailExistErr = (String) session.getAttribute("emailExistErr");
            String updateErr = (String) session.getAttribute("updateErr");
        %>        
    </head>
    <body>
        <div class="container">
            <h1>Edit details</h1>
            <small class="text-danger"><%=(emailExistErr != null ? emailExistErr : "")%></small>
            <small class="text-danger"><%=(updateErr != null ? updateErr : "")%></small>
            <form method="post" action="EditUserServlet">
                <table class="table table-bordered text-nowrap">
                    <tbody>
                        <tr>
                            <th>Email <small class="text-danger"><%=(emailErr != null ? emailErr : "")%></small></th>                            
                            <td><input class="form-control" type="text" name="email" value="${user.userEmail}" required></td>
                        </tr>
                        <tr>
                            <th>First Name <small class="text-danger"><%=(firstNameErr != null ? firstNameErr : "")%></small></th>
                            <td><input class="form-control" type="text" name="firstName" value="${user.userFirstName}" required></td>
                        </tr>
                        <tr>
                            <th>Last Name <small class="text-danger"><%=(lastNameErr != null ? lastNameErr : "")%></small></th>
                            <td><input class="form-control" type="text" name="lastName" value="${user.userLastName}" required></td>
                        </tr>
                        <tr>
                            <th>Password <small class="text-danger"><%=(passErr != null ? passErr : "")%></small></th>
                            <td><input class="form-control" type="text" name="password" value="${user.password}" required></td>                            
                        </tr>
                        <tr>
                            <th>Phone Number <small class="text-danger"><%=(phoneErr != null ? phoneErr : "")%></small></th>                            
                            <td><input class="form-control" type="text" name="phoneNumber" value="${user.phoneNumber}"></td>
                        </tr>
                    </tbody>                                                        
                </table>
                <div class="form-row">
                    <div class="form-group col">
                        <a href="account.jsp"><button type="button" class="btn btn-secondary btn-lg btn-block">Back</button></a>
                    </div>
                    <div class="form-group col">
                        <button class="btn btn-primary btn-lg btn-block" type="submit">Submit</button>                
                    </div>
                </div>
            </form>
        </div>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
