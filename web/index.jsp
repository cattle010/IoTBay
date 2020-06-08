<%-- 
    Document   : index
    Created on : 2020-6-3, 20:50:00
    Author     : Xuanhao Zhou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index page</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    </head>
    <body>
        <h1>Hello!</h1>
        <a class="button" href="view.jsp">Staff interface</a>
        <a class="button" href="userview.jsp">User interface</a>
        
        <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>
