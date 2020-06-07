<%-- 
    Document   : CustomerOrder
    Created on : 06/06/2020, 5:38:41 PM
    Author     : Kelvin Wang
--%>

<%@page import="uts.isd.model.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <title>Customer Order Page</title>
    </head>
    <%
        Order order = (Order) session.getAttribute("show");
        String creationConfirmation = (String) request.getParameter("creationConfirmation");
    %>
    <body>
        <h1>Customer Order</h1>
        <p class="right"> <a class="button21" href="addorder.jsp">Add Order</a> </p>
        <p class="right"> <a class="button21" href="updateorder.jsp">Update Order</a> </p>
        <p class="right"> <a class="button21" href="removeorder.jsp">Remove Order</a> </p>
        <span><%=creationConfirmation != null ? creationConfirmation : ""%></span>
        <form method="get">
            <form>
                Search Order:
                <input type="text" id="searchordernumber" onkeyup="myFunction()" placeholder="ID" title="Type in order ID">
                <input type="text" id="searchorderdate" onkeyup="myFunction()" placeholder="Order Date" title="Type in a date">
            </form>
            <table border="1" id="ordertable">
                <tr>
                    <th>OrderID</th>
                    <th>Status of Order</th>
                    <th>Order Date</th>
                    <th>Shipping Date</th>
                </tr>
                <c:forEach order="$(show)" var="show">
                <tr>
                                <td>${show.orderID}</td>
                                <td>${show.orderStatus}</td>
                                <td>${show.orderDate}</td>
                                <td>${show.shipDate}</td>
                </tr>
            </table>
        </form>
        <div class="form-group">
        <a class="form-text text-muted" href="accounts.jsp">Back to Account Page</a>
        </div>
    </body>
</html>
