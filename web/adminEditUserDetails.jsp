<%-- 
    Document   : editUserDetails
    Created on : 04/06/2020, 3:59:15 PM
    Author     : xun.s.chang
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
            User editUser = (User) request.getAttribute("editUser");
            
        %>        
    </head>
    <body>
        <div class="container">
            <h1>Edit details</h1>
            
            <form method="post" action="editServlet">
                <input type="hidden" name="userid" value="<%=editUser.getUserID()%>">
                <table class="table table-bordered text-nowrap">
                    <tbody>
                        <tr>
                            <th>Email </th>                            
                            <td><input class="form-control" type="text" name="email" value="<%=editUser.getUserEmail()%>" required></td>
                        </tr>
                        <tr>
                            <th>First Name </th>
                            <td><input class="form-control" type="text" name="firstName" value="<%=editUser.getUserFirstName()%>" required></td>
                        </tr>
                        <tr>
                            <th>Last Name </th>
                            <td><input class="form-control" type="text" name="lastName" value="<%=editUser.getUserLastName()%>" required></td>
                        </tr>
                        <tr>
                            <th>Password </th>
                            <td><input class="form-control" type="text" name="password" value="<%=editUser.getPassword()%>" required></td>                            
                        </tr>
                        <tr>
                            <th>Phone Number </th>                            
                            <td><input class="form-control" type="text" name="phoneNumber" value="<%=editUser.getPhoneNumber()%>"></td>
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
