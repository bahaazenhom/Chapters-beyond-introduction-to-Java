<%-- 
    Document   : FactorialBean
    Created on : Oct 2, 2023, 12:21:16 AM
    Author     : bahaa
--%>

<%@page import = "Chapter_38.FactorialBean" contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id = "factorialBeanId" class = "Chapter_38.FactorialBean" scope = "page">
</jsp:useBean>
<jsp:setProperty name = "factorialBeanId" property = "*"/> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factorial Bean</title>
    </head>
    <body>
        <h3>Computer factorial Using a Bean</h3>
        <form method ="post">
            Enter new value: <input name = "number"/><br/><br/><!-- comment -->
            <input type ="submit" name ="Submit" value = "Compute Factorial"/>
            <input type="reset" value ="Resest"/> <br/><br/>
            Factorial Of <jsp:getProperty name = "factorialBeanId" property="number"/> is
            <%= Chapter_38.FactorialBean.format(factorialBeanId.getFactorial())%>

    </body>
</html>
