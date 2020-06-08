<%-- 
    Document   : updateorder
    Created on : 07/06/2020, 7:31:37 PM
    Author     : Kelvin Wang
--%>

<%@page import="uts.isd.model.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Update Order</title>
    </head>
    <%
            Order order = (Order) session.getAttribute("order");
            String orderErr = (String) session.getAttribute("orderErr");
            String paymentErr = (String) session.getAttribute("paymentErr");
            String shippingaddErr = (String) session.getAttribute("shippingaddErr");
            String updated = (String) request.getParameter("updated");
    %>        
                <h1>Update an order here:</h1>
                <span><%= ( updated != null) ? "Updated successfully":""%></span>
                <form method="get">
                    <div>
                        <label>Want to change an order? Enter Order ID:</label> 
                        <input name="orderid" type="text" class="form-control" placeholder="Enter order id...">
                    </div>
                    <div>
                        <label for="userid">User ID</label> 
                        <input name="userid" type="text" class="form-control" placeholder="Enter user id...">
                    </div>
                    <div>
                        <label for="paymentid">Payment ID</label> 
                        <small class="text-danger"><%=(paymentErr != null ? shippingaddErr : "")%></small>
                        <input name="paymentid" type="text" class="form-control" placeholder="Enter payment id...">
                    </div>
                    <div>
                        <label for="shipaddid">Shipping Address ID</label>
                        <small class="text-danger"><%=(shippingaddErr != null ? shippingaddErr : "")%></small>
                        <input name="shipaddid" type="text" class="form-control" placeholder="Enter shipping address id...">
                    </div>
                    <div>
                        <input type="submit" value="Update">
                        <a href="CustomerOrder.jsp" type="button" class="btn btn-secondary">Cancel</a>
                    </div>
                </form>
                        <%
                    int orderid = Integer.parseInt(request.getParameter("orderid"));
                    int userid = Integer.parseInt(request.getParameter("userid"));
                    int paymentid = Integer.parseInt(request.getParameter("paymentid"));
                    int shippingaddressid = Integer.parseInt(request.getParameter("shippingaddressid")); 
                    session.setAttribute("order", order);
                    order = new Order(orderid, userid, paymentid, shippingaddressid, null, null, "in-progress");
                 %>
</html>
