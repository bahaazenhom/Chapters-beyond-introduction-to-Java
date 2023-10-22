<%-- 
    Document   : GradeQuiz
    Created on : Oct 21, 2023, 9:05:42 PM
    Author     : bahaa
--%>

<%@page import = "myWebService.QuizWebService" %>
<%@page import = "myWebService.QuizService" %>
<%@page import = "java.util.ArrayList" %>
<%@page import = "java.lang.String" %>
<jsp:useBean id="quizWebService" scope = "session" class="myWebService.QuizWebService"></jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            QuizService proxy = quizWebService.getQuizServicePort();
                ArrayList<String> quiz = (ArrayList<String>) proxy.getQuestions();
                ArrayList<Boolean> answers = new ArrayList<Boolean>();
                for (int i = 0; i < quiz.size(); i++) {
                    String trueOrFalse = request.getParameter("question" + i);
                    if (trueOrFalse.equals("True")) {
                        answers.add(true);
                    } else {
                        answers.add(false);
                    }
                }
                ArrayList<Boolean> result = (ArrayList<Boolean>) proxy.gradeQuiz(answers);
                int correctCount = 0;
                for (int i = 0; i < result.size(); i++) {
                    correctCount += result.get(i) ? 1 : 0;
                }
        %>
        Out of <%= result.size()%> questions, <%= correctCount%> correct.
    </head>
    <body>

    </body>
</html>
