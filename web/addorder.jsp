<%-- 
    Document   : addorder
    Created on : 07/06/2020, 7:21:50 PM
    Author     : Kelvin Wang
--%>

<%@page import="uts.isd.model.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Add Order</title>
    </head>
    <%
            Order order = (Order) session.getAttribute("show");
            session.setAttribute("creationConfirmation", "");
    %>
    <body>
        <h1>Adding an order</h1>
        <div class="maincolumn2">
            <div class="card">
                <h1>Add New Order </h1>
                        <tr><td>Products being chosen:</td><td><input type="text"></td></tr>
                        <tr><td>Company:</td><td><input type="text" ></td></tr>
                        <tr><td>Email:</td><td><input type="text" ></td></tr>
                        <tr><td>Address:</td><td><input type="text" "></td></tr>
                        <tr><td>Activated:</td><td><input type="checkbox" name="active"></td></tr> 
                    </table>
                    <div>
                        <input class ="button4" type="submit" value="Add">
                        <a class ="button3" href="SupplierListServlet">Cancel</a>
                        <p class ="error"><%=(exceptionErr != null ? exceptionErr : "")%>
                            <%
                                  session.setAttribute("exceptionSupplierErr", "");
                             %>
                    </div>
                    
                </form>
            </div>
        </div>
    </body>
</html>
