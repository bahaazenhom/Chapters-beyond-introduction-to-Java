<%-- 
    Document   : Table
    Created on : Oct 2, 2023, 4:03:42 AM
    Author     : bahaa
--%>

<%@page import = "Chapter_38.DBBean" contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="dBBeanId" class="Chapter_38.DBBean" scope="session"></jsp:useBean>

    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Table</title>
        </head>
        <body>
        <% String[] tables = dBBeanId.getTables();
            if (tables == null)
                out.println("No tables");
            else {%>
        <form method="post" action="BrowseTable.jsp">
            Select Table 
            <select name="tablename" size ="1">
                <% for (int i = 0; i < tables.length; i++) {%>
                <option>
                    <%= tables[i]%>
                </option>          
                <%}%>
                <%}%>
            </select><br/><br/>
            <input type = "submit" name = "Submit" value = "Browse Table Content">
            <input type = "reset" value = "Reset">
        </form>


    </body>
</html>
