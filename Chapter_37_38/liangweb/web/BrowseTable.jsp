<%-- 
    Document   : BrowseTable
    Created on : Oct 2, 2023, 4:10:45 AM
    Author     : bahaa
--%>

<%@page import = "Chapter_38.DBBean" contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="dBBeanId" class="Chapter_38.DBBean" scope = "session"></jsp:useBean>
<%@page import = "java.sql.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Browse Table</title>
    </head>
    <body>
        <% String tableName = request.getParameter("tablename");
            ResultSet rsColumns = dBBeanId.getConnection().getMetaData().getColumns(null, null, tableName, null);
        %>
        <table border="1">
            <tr>
                <% while (rsColumns.next()) {%>
                <td><%= rsColumns.getString("COLUMN_NAME")%></td>
                <%}%>
            </tr>
            <% Statement statement = dBBeanId.getConnection().createStatement();
                ResultSet rs = statement.executeQuery("select * from " + tableName);
                int columnCount = rs.getMetaData().getColumnCount();
                while (rs.next()) {%>
            <tr>
                <% for (int i = 1; i <= columnCount; i++) {%>
                <td><%=rs.getObject(i)%></td>
                <%}%>    
            </tr>
            <%}%>    
        </table>
    </body>
</html>
