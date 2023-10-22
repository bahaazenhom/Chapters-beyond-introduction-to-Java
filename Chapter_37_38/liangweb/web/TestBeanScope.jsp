<%-- 
    Document   : TestBeanScope
    Created on : Oct 1, 2023, 11:45:42 PM
    Author     : bahaa
--%>

<%@page import = "Chapter_37.Count" contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id = "count" scope = "application" class = "Chapter_37.Count" >
</jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test Bean Scope</title>
    </head>
    <body>
        <h3>Testing Bean Scope in JSP (Application)</h3>
        <% count.increaseCount();%>
        You are visitor number <%= count.getCount()%><br/>
        From host: <%= request.getRemoteHost()%>
        and session: <%= session.getId()%>
    </body>
</html>
