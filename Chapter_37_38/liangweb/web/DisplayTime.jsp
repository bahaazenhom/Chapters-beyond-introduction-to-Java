<%-- 
    Document   : DisplayTime
    Created on : Oct 2, 2023, 1:28:36 AM
    Author     : bahaa
--%>

<%@page import="Chapter_38.TimeBean" contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id = "timeBeanId" class ="Chapter_38.TimeBean" scope = "application"></jsp:useBean>
<jsp:setProperty name="timeBeanId" property="*"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Time</title>
    </head>
    <body>
        <h3>Local and time zone</h3>
        Current time is <%= timeBeanId.currentTimeString(timeBeanId.getLocaleIndex(), timeBeanId.getTimeZoneIndex())%>
    </body>
</html>
