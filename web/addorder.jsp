
<%-- 
    Document   : addorder
    Created on : 07/06/2020, 7:21:50 PM
    Author     : Kelvin Wang
--%>

<%@page import="uts.isd.model.Order"%>
<%@page import="java.time.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Add Order Page</title>
    </head>
    <%
            Order order = (Order) session.getAttribute("order");
            String orderErr = (String) session.getAttribute("orderErr");
            String paymentErr = (String) session.getAttribute("paymentErr");
            String shippingaddErr = (String) session.getAttribute("shippingaddErr");
            session.setAttribute("creationConfirmation", "");
            String creationconf = (String) request.getParameter("creationconf");
    %>
    <body>
        <div>
                <h1>Add New Order </h1>
                <span><%= ( creationconf != null) ? "Added Order successfully":""%></span>
                <form>
                    <div>
                        <label>Current Date: <script>document.getElementById("date").innerHTML = Date();</script></label>
                    </div>
                    <div>
                        <label for="orderid">Order ID</label> 
                        <small class="text-danger"><%=(orderErr != null ? orderErr : "")%></small>
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
                        <a href="addedorder.jsp" type="button" class="btn btn-secondary btn-lg">Add to your order</a>
                        <a href="account.jsp" type="button" class="btn btn-secondary btn-lg">Go back to your account</a>
                    </div>
                </form>
                
                <%
                    int orderid = Integer.parseInt(request.getParameter("orderid"));
                    int userid = Integer.parseInt(request.getParameter("userid"));
                    int paymentid = Integer.parseInt(request.getParameter("paymentid"));
                    int shippingaddressid = Integer.parseInt(request.getParameter("shippingaddressid"));
                    order = new Order(orderid, userid, paymentid, shippingaddressid, null, null, "in-progress");
                 %>
        </div>
    </body>
</html>
