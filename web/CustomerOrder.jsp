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
        Order order = (Order) session.getAttribute("order");
                    String userid = request.getParameter("userid");
                    String orderid = request.getParameter("orderid");
                    String shippingaddressid = request.getParameter("shippingaddress");
                    String orderdate = request.getParameter("orderdate");
                    String shipdate = request.getParameter("shipdate");
                    String orderstatus = request.getParameter("orderstatus");
    %>
    <body>
        <h1>Customer Order</h1>
        <p> Your User ID is: ${order.userID}</p>
        <p> <a href="addorder.jsp" type="button" class="btn btn-secondary">Add Order</a> </p>
        <p> <a href="updateorder.jsp" type="button" class="btn btn-secondary">Update Order</a> </p>
        <p"> <a href="removeorder.jsp" type="button" class="btn btn-secondary ">Remove Order</a> </p>
        <form method="get">
            <form>
                Search Order:
                <input type="text" placeholder="ID" title="Type in order ID">
                <input type="text" placeholder="Order Date" title="Type in a date">
            </form>
            <table border="1">
                <tr>
                    <th>OrderID</th>
                    <th>Status of Order</th>
                    <th>Order Date</th>
                    <th>Shipping Date</th>
                </tr>
                <c:forEach order="${order}" var="order">
                <tr>
                                <td>${order.orderID}</td>
                                <td>${order.orderStatus}</td>
                                <td>${order.orderDate}</td>
                                <td>${order.shipDate}</td>
                </tr>
            </table>
        </form>
                </br>
                </br>
        <div class="form-group col">
        <a href="index.jsp" type="button" class="btn btn-lg btn-secondary btn-block">Back</a>
        </div>
    </body>
</html>
