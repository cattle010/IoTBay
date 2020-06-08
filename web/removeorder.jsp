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
            Order order = (Order) session.getAttribute("order");
    %>
    <body>
        <h1>Remove an Order</h1>
        <p> <a href="CustomerOrder.jsp" type="button" class="btn btn-secondary btn-lg btn-block">View Orders</a> </p>
        <div class="form-group col">
     
                <form method="get">
                    
                  <table>
                         <tr>
                            <td>Order ID</td>
                            <td><input type="text" name="orderID"></td>
                        </tr>
                    </table>
                       
                    <div>
                        <input type="submit" value="Delete">
                        <a href="CustomerOrder.jsp" type="button" class="btn btn-secondary btn-lg btn-block">Back</a>
                    </div>
                </form>
        </div>
             <%
                    int orderid = Integer.parseInt(request.getParameter("orderid"));
                    int userid = Integer.parseInt(request.getParameter("userid"));
                    int paymentid = Integer.parseInt(request.getParameter("paymentid"));
                    int shippingaddressid = Integer.getInteger(request.getParameter("shippingaddressid"));
                    session.setAttribute("order", order);
                    order = new Order(orderid, userid, paymentid, shippingaddressid, null, null, null);
                 %>
    </body>
</html>
