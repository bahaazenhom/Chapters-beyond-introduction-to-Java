<%-- 
    Document   : StoreStudent
    Created on : Oct 2, 2023, 3:17:24 AM
    Author     : bahaa
--%>

<%@page import="Chapter_37.Address" contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="addressId" class="Chapter_37.Address" scope = "session"></jsp:useBean>
<jsp:setProperty name="addressId" property="*"/>
<jsp:useBean id="storeDataId" class="Chapter_38.StoreDate" scope="application"></jsp:useBean>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Store Date</title>
        </head>
        <body>
        <%
            storeDataId.storeStudent(addressId);
            out.println(addressId.getFirstName() + " " + addressId.getLastName() + " is now registered"
                    + "in the database");
            out.close();
        %>

    </body>
</html>
