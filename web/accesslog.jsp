<%-- 
    Document   : accesslog
    Created on : 06/06/2020, 1:40:19 AM
    Author     : jason
--%>

<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date"%>
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
            String timeFilterErr = (String) session.getAttribute("timeFilterErr");            
            String dateParseError = (String) session.getAttribute("dateParseError"); 
            String filterErr = (String) session.getAttribute("filterErr");
            String filterText = (String) session.getAttribute("filterText");
            ArrayList<AccessLog> accessLogs = new ArrayList<AccessLog>();
            accessLogs = (ArrayList) session.getAttribute("accessLogs");
            Date date = new Date();
            Timestamp time = new Timestamp(date.getTime());
        %>
    </head>
    <body>
        <div class="container">
            <h1>Access Logs</h1>
            <form method="post" action="ViewAccessLogsServlet">
                <div class="form-row">
                    <div class="form-group col">
                        <label for="startDate">Start date:</label>
                            <input type="date" name="startDate">
                        <label for="startDate">End date:</label>
                            <input type="date" name="endDate">
                            <button class="btn btn-primary btn-sm btn-inline" type="submit">Search</button>
                    </div>                    
                </div>                                                               
            </form>
            <div class="form-group">
                <small class="text-danger"><%=(timeFilterErr != null ? timeFilterErr : "")%></small>                
                <small class="text-danger"><%=(dateParseError != null ? dateParseError : "")%></small>
                <small class="text-danger"><%=(filterErr != null ? filterErr : "")%></small>
                <small class="text-secondary"><%=(filterText != null ? filterText : "")%></small>                
            </div>
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
