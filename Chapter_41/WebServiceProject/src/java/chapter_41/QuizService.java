/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter_41;

import java.util.ArrayList;
import java.util.Collections;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import com.sun.xml.ws.developer.servlet.HttpSessionScope;

/**
 *
 * @author bahaa
 */
@HttpSessionScope
@WebService(name = "QuizService", serviceName = "QuizWebService")
public class QuizService {

    private ArrayList<Object[]> quiz = new ArrayList<>();

    public QuizService() {
        quiz.add(new Object[]{
            "Is Atlanta the capital of Georgia?", true});
        quiz.add(new Object[]{
            "Is Columbia the capital of South Carolina?", true});
        quiz.add(new Object[]{
            "Is Fort Wayne the capital of Indiana?", false});
        quiz.add(new Object[]{
            "Is New Orleans the capital of Louisiana?", false});
        quiz.add(new Object[]{
            "Is Chicago the capital of Illinois?", false});

        Collections.shuffle(quiz);
    }

    @WebMethod(operationName = "getQuestions")
    public ArrayList<String> getQuestions() {
        ArrayList<String> questions = new ArrayList<>();
        for (int i = 0; i < quiz.size(); i++) {
            questions.add((String) quiz.get(i)[0]);
        }
        return questions;
    }

    @WebMethod(operationName = "gradeQuiz")
    public ArrayList<Boolean> gradeQuiz(ArrayList<Boolean> answers) {
        ArrayList<Boolean> result = new ArrayList<>();
        for (int i = 0; i < quiz.size(); i++) {
            result.add(quiz.get(i)[1] == answers.get(i));
        }
        return result;
    }
}
