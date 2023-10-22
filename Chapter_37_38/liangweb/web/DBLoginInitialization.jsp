<%-- 
    Document   : DBLoginInitialization
    Created on : Oct 2, 2023, 3:55:00 AM
    Author     : bahaa
--%>

<%@page import = "Chapter_38.DBBean" contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="dBBeanId" class = "Chapter_38.DBBean" scope="session"></jsp:useBean>
<jsp:setProperty name="dBBeanId" property="*" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DB Login Initialization </title>
    </head>
    <body>
        <% dBBeanId.initializeJdbc();%>
        <% if(dBBeanId.getConnection() == null)out.println("Error: Login failed. Try Again");
        else{%><jsp:forward page="Table.jsp"/>
        <%}%>
    </body>
</html>
