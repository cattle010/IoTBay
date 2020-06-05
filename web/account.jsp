<%-- 
    Document   : account
    Created on : 04/06/2020, 1:51:54 PM
    Author     : jason
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <title>Account</title>
        <%
            User user = (User) session.getAttribute("user");
        %>    
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">IoTBay</h1>            
            <nav class="nav justify-content-center">
                <a class="nav-link nav-item active" href="account.jsp">Account</a>                    
                <a class="nav-link nav-item active" href="logout.jsp">Logout</a>
            </nav>
            <div class="row">
                <div class="container">
                    <h2>Hi there ${user.userFirstName},</h2>
                    <p>Welcome to your account page, here you can view and edit your settings as well as check out your access logs through the links on the menu below.</p>
                </div>
                    <div class="container">
                        <h4>Account Details</h4>
                    </div>
                <div class="col">                    
                    <div>                        
                        <table class="table table-bordered text-nowrap">
                            <tbody>
                                <tr>
                                    <th class="">Email</th>
                                    <td>${user.userEmail}</td>
                                </tr>
                                <tr>
                                    <th class="">First Name</th>
                                    <td>${user.userFirstName}</td>
                                </tr>
                                <tr>
                                    <th class="">Last Name</th>
                                    <td>${user.userLastName}</td>
                                </tr>
                                <tr>
                                    <th class="">Password</th>
                                    <td>${user.password}</td>
                                </tr>
                                <tr>
                                    <th class="">Phone Number</th>
                                    <% if (user.getPhoneNumber().isEmpty()) { %>
                                       <td>You have not entered a phone number</td>
                                    <% } else { %>
                                       <td>${user.phoneNumber}</td>
                                    <% } %>
                                </tr>
                            </tbody>                                                        
                        </table>
                        <div class="text-right">
                            <a href="deleteUser.jsp"><button type="button" class="btn btn-danger">Delete Account</button></a>
                        </div>
                    </div>
                </div>
                <div class="sidebar-expanded col-2 d-none d-md-block">                    
                    <nav class="list-group sticky-top sticky-offset">
                        <a class="nav-link nav-item active" href="editUserDetails.jsp">Edit Details</a>
                        <a class="nav-link nav-item active" href="ViewAccessLogsServlet">Access Logs</a>
                    </nav>                    
                </div>
            </div>
        </div>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
