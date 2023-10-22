/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chapter_41;

import myWebService.*;

/**
 *
 * @author bahaa
 */
public class FindScoreApp {
    private ScoreWebService scoreWebService = new ScoreWebService();
    private ScoreService proxy = scoreWebService.getScoreServicePort();
    
    private void getScore(String name){
        try{
        double score = proxy.findScore(name);
        if(score<0)System.out.println("Not found");
        else System.out.println(score);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    
}
