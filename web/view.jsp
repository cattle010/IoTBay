<%-- 
    Document   : edit
    Created on : 2020-6-3, 20:57:43
    Author     : Xuanhao Zhou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="uts.isd.model.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <style>
            table {
  border-collapse: collapse;
  width: 80%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: #0cafeb;
  color: white;
}

         
        #myInput {
        background-image: url('/css/searchicon.png');
        background-position: 10px 10px;
        background-repeat: no-repeat;
        width: 50%;
        font-size: 14px;
        padding: 12px 20px 12px 40px;
        border: 1px solid #ddd;
        margin-bottom: 12px;
            }
        </style>
    </head>
    <body>
        <% ArrayList<Product> pro = (ArrayList<Product>)session.getAttribute("products");%>
        
    <center>
        <h1>Product information</h1>   
    </center> 
    

    
    <div class="container">
        <div>
        
             <div style="text-align: right">
             <a class="button" href="add.jsp">Add new product</a>
             </div>
             <input type="text"  id="myInput"
           onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">
           
        </div>
        
        <table style="width:100%" id="myTable">
            <thead><th>Product ID</th><th>Name</th><th>Brand Name</th><th>Description</th><th>Cost per unit</th><th>Stock</th><th>Action</th></thead>
        
        <c:forEach items="${products}" var="p">
                 <tr>
                    <td><c:out value="${p.productID}" /></td>
                    <td>${p.productName}</td>
                    <td>${p.brandName}</td>
                    <td>${p.description}</td>
                    <td>${p.costPerUnit}</td>
                    <td>${p.stock}</td>
                    
                    <td>
                        <a class="button" href="EditServlet?pID=${p.productID}">Update</a>
                        <a class="button" href="DeleteServlet?pID=${p.productID}">Delete</a>
                    </td>    
        </tr>
        </c:forEach>
        </table>
        
        
    </div>
    
    
    <a href="index.jsp"><button type="button" class="btn btn-secondary btn-lg btn-block">Back</button></a>

    <script src="js/tablescript.js" type="text/javascript"></script>
    </body>
</html>
 