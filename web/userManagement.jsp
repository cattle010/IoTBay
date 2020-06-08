<%-- 
    Document   : userManagement
    Created on : 30/05/2020, 1:43:02 AM
    Author     : xun.s.chang
--%>

<%@page import="uts.isd.model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>User Management</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body>  

<!--Header-part-->
<div id="header">
  <h1><a href="dashboard.html">User Management</a></h1>
</div>
<!--close-Header-part--> 

<!--top-Header-menu-->


<!--start-top-search-->
<div>
    <a href="adminRegisterServlet">Add User</a>
</div>
<!--close-top-search--> 
<%
    ArrayList<User> userInfo = (ArrayList<User>)request.getAttribute("UserList");
%>  
<!--sidebar-menu-->
    <div class="widget-content nopadding">
     <table class="table table-bordered table-striped">
       <thead>
         <tr>
           <th>UserID</th>
           <th>Email(s)</th>
           <th>First Name</th>
           <th>Last Name</th>
           <th>Password</th>
           <th>Phone Number</th>
           <th>Staff User</th>
           <th>Registered User</th>
           <th></th>
           <th></th>
           <th></th>
         </tr>
       </thead>
       <tbody>
           <%
                for(User user: userInfo){
           %> 
                <tr class="odd gradeX">
                    <td><%=user.getUserID()%></td> 
                    <td><%=user.getUserEmail()%></td>
                    <td><%=user.getUserFirstName()%></td>
                    <td><%=user.getUserLastName()%></td>
                    <td><%=user.getPassword()%></td>
                    <td><%=user.getPhoneNumber()%></td>
                    <td><%=user.isIsStaffUser()%></td>
                    <td><%=user.isIsRegisteredUser()%></td>
                    <td><a href="adminViewServlet?useremail=<%=user.getUserEmail()%>">view user</a></td> 
                    <td><a href="editServlet?useremail=<%=user.getUserEmail()%>">update user</a></td> 
                    <td><a href="javascript:ddd('Are you sure want to detele this user?','deleteServlet?userid=<%=user.getUserID()%>')">delete user</a></td> 
                </tr>
           <%
                } 
           %>
       </tbody>
     </table>
    </div>
       <script>
           function ddd(str, url){
               if(confirm(str)) location.href = url;
           }
       </script> 
</body>
</html>
