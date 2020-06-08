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
            User adminUser = (User) request.getAttribute("editUser");
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
                        <h4>Account Details</h4>
                    </div>
                <div class="col">                    
                    <div>                        
                        <table class="table table-bordered text-nowrap">
                            <tbody>
                                <tr>
                                    <th class="">Email</th>
                                    <td><%=adminUser.getUserEmail()%></td>
                                </tr>
                                <tr>
                                    <th class="">First Name</th>
                                    <td><%=adminUser.getUserFirstName()%></td>
                                </tr>
                                <tr>
                                    <th class="">Last Name</th>
                                    <td><%=adminUser.getUserLastName()%></td>
                                </tr>
                                <tr>
                                    <th class="">Password</th>
                                    <td><%=adminUser.getPassword()%></td>
                                </tr>
                                <tr>
                                    <th class="">Phone Number</th>
                                    <% if (adminUser.getPhoneNumber().isEmpty()) { %>
                                       <td>User have not entered a phone number</td>
                                    <% } else { %>
                                       <td><%=adminUser.getPhoneNumber()%></td>
                                    <% } %>
                                </tr>
                            </tbody>                                                        
                        </table>
                        <div class="text-right">
                            <a href="ListUserServlet"><button type="button" class="btn btn-danger">Back</button></a>
                        </div>
                    </div>
                </div>
                
            </div>
        </div>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
