<%-- 
    Document   : DisplayTimeForm
    Created on : Oct 2, 2023, 1:20:03 AM
    Author     : bahaa
--%>

<%@page import = "Chapter_38.TimeBean" contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id = "timeBeanId" class = "Chapter_38.TimeBean" scope = "application"></jsp:useBean>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Display Time Form</title>
        </head>
        <body>
            <h3>Choose locale and time zone</h3>
            <form method ="post" action="DisplayTime.jsp">
                Locale <select size="1" name="localeIndex">
                <% for (int i = 0; i < timeBeanId.getAllLocale().length; i++) {%>
                <option value="<%=i%>">
                    <%= timeBeanId.getAllLocale()[i]%>
                </option>
                <%}%>
            </select>

            Time Zone <select size="1" name="timeZoneIndex">
                <% for (int i = 0; i < timeBeanId.getAllTimeZone().length; i++) {%>
                <option value="<%=i%>">
                    <%= timeBeanId.getAllTimeZone()[i]%>
                </option>
                <%}%>
            </select><br/> <br/>
            <input type="submit" name="Submit" value ="Get Time"/>
            <input type ="reset" value="Reset"/>

        </form>
    </body>
</html>
