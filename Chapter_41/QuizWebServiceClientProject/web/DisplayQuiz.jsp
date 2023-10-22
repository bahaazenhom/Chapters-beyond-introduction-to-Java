<%-- 
    Document   : DisplayQuiz
    Created on : Oct 21, 2023, 8:28:53 PM
    Author     : bahaa
--%>
<%@page import = "myWebService.QuizWebService" %>
<%@page import = "myWebService.QuizService" %>
<%@page import = "java.util.*" %>
<%@page import = "java.lang.*" %>
<jsp:useBean id="quizWebService" scope = "session" class="myWebService.QuizWebService"></jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

    </head>
    <body>
        <%
            QuizService proxy = quizWebService.getQuizServicePort();
            ArrayList<String> questions = (ArrayList<String>) proxy.getQuestions();
        %>
        <form method = "post" action ="GradeQuiz.jsp">
            <table>
                <% for (int i = 0; i < questions.size(); i++) {%>
                <tr>
                    <td>
                        <label><%= questions.get(i)%></label>
                    </td>
                    <td>
                        <input type ="radio" name = <%= "question" + i%>
                               value="True"/>True
                    </td>
                    <td>
                        <input type ="radio" name = <%= "question" + i%>
                               value="False"/>False
                    </td>
                </tr>  
                <%}%>
            </table>
            <p><input type ="submit" name ="Submit" value="Submit">
                <input type ="reset" value="Reset">
            </p>
        </form>
    </body>
</html>
