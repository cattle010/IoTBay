<%-- 
    Document   : removeorder
    Created on : 07/06/2020, 7:31:45 PM
    Author     : Kelvin Wang
--%>

<%@page import="uts.isd.model.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Remove Order</title>
    </head>
    <%
            Order order = (Order) session.getAttribute("show");
    %>
    <body>
        <h1>Remove an Order</h1>
        <p class="right"> <a class="button21" href="customerorders.jsp">View Orders</a> </p>
        <div class="maincolumn2">
            <div class="card">
     
                <form method="get">
                    
                  <table>
                         <tr>
                            <td>OrderID</td>
                            <td><input type="text" value="${order.orderID}" name="orderID"></td>
                        </tr>
                    </table>
                       
                    <div>
                        <input class ="button4" type="submit" value="Delete">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
