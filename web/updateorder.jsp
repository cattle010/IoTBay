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
            Order order = (Order) session.getAttribute("show");
    %>
    <body>
        <div class="maincolumn2">
        <div class="card">

            </head>
            <body>

                <h1>Update an order here:</h1>

                <form method="get" action="UpdateSupplierServlet">
                    <table>
                        <tr>
                            <td><input type="text" placeholder="enter order id" name="orderid"></td>
                        </tr>
                    </table>
                    <div>
                        <input class ="button4" type="submit" value="Search">
                        <a class ="button3" href="customerorder.jsp">Cancel</a>
                    </div>
                </form>
            </body>
        </div>
    </div>
    </body>
</html>
