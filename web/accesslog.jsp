<%-- 
    Document   : accesslog
    Created on : 06/06/2020, 1:40:19 AM
    Author     : jason
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.AccessLog"%>
<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <title>Access Logs</title>
        <%
            User user = (User) session.getAttribute("user");
            ArrayList<AccessLog> accessLogs = new ArrayList<AccessLog>();
            accessLogs = (ArrayList) session.getAttribute("accessLogs");
        %>
    </head>
    <body>
        <div class="container">
            <h1>Access Logs</h1>
            <table class="table table-bordered text-nowrap">
                <thead>
                    <tr>
                        <th>Log time</th>
                        <th>Log event</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${accessLogs}" var="accessLog">
                        <tr>
                            <td>${accessLog.getPrettyLogEventTime()}</td>
                            <td>${accessLog.getLogEvent()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="form-row">
                    <div class="form-group col">
                        <a href="account.jsp"><button type="button" class="btn btn-secondary btn-lg btn-block">Back</button></a>
                    </div>                    
            </div>
        </div>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
