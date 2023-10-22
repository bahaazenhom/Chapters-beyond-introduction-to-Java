<%-- 
    Document   : CurrentTime
    Created on : Oct 1, 2023, 2:11:49 AM
    Author     : bahaa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Current Time</title>
    </head>
    <body>
        <% for (int i = 0; i <= 10; i++) {%>
        Factorial of <%= i%> is 
        <%= computeFactorial(i)%> </br>
        <% }%>
        <%! private long computeFactorial(int n) {
                if (n == 0) {
                    return 1;
                }
                return n * computeFactorial(n - 1);
            }
        %>
    </body>
</html>
