<%-- 
    Document   : GetRegistrationData
    Created on : Oct 2, 2023, 3:10:23 AM
    Author     : bahaa
--%>

<%@page import="Chapter_37.Address" contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id = "addressId" class="Chapter_37.Address" scope = "session"></jsp:useBean>
<jsp:setProperty name="addressId" property="*"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Data</title>
    </head>
    <body>
        <h1>Registration using JSP</h1>
        <%
            if (addressId.getFirstName() == null || addressId.getLastName() == null) {
                out.println("First Name and Last Name are required");
                return;
            }
        %>
        <p>You entered the following data</p><br/>
        <p>Last name: <%= addressId.getLastName()%></p>
        <p>First name: <%= addressId.getFirstName()%></p>
        <p>MI: <%= addressId.getMi()%></p>
        <p>Telephone: <%= addressId.getTelephone()%></p>
        <p>Email: <%= addressId.getEmail()%></p>
        <p>Address: <%= addressId.getStreet()%></p>
        <p>City: <%= addressId.getCity()%></p>
        <p>State: <%= addressId.getState()%></p>
        <p>Zip: <%= addressId.getZip()%></p>
        <form method="post" action ="StoreStudent.jsp">
            <input type="submit" value="Confirm">
        </form>
    </body>
</html>
