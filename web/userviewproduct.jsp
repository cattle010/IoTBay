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
        <link rel="stylesheet" type="text/css" href="css/tablestyle.css">
        <style>

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
        <h1>Products information</h1>    
    
        <input type="text"  id="myInput"
           onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">
    
    
    
    
        
        <table style="width:75%" id="myTable">
            <thead><th>Product ID</th><th>Name</th><th>Brand Name</th><th>Description</th><th>Cost per unit</th><th>Stock</th></thead>
        
        <c:forEach items="${products}" var="p">
                 <tr>
                    <td><c:out value="${p.productID}" /></td>
                    <td>${p.productName}</td>
                    <td>${p.brandName}</td>
                    <td>${p.description}</td>
                    <td>${p.costPerUnit}</td>
                    <td>${p.stock}</td> 
        </tr>
        </c:forEach>
        </table>
    </center>
    
    
        <div style="text-align: center">
            <a href="index.jsp" class="button">Back</button></a>
        </div>
    
    
    <script src="js/tablescript.js" type="text/javascript"></script>
    </body>
</html>
 