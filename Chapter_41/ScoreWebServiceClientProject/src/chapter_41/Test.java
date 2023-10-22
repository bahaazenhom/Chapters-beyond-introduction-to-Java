/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chapter_41;

import java.util.Scanner;
import myWebService.ScoreService;
import myWebService.ScoreWebService;

/**
 *
 * @author bahaa
 */
public class Test {
    private static ScoreWebService scoreWebService = new ScoreWebService();
    private static ScoreService proxy = scoreWebService.getScoreServicePort();
    
    public static void getScore(String name){
        try{
        double score = proxy.findScore(name);
        if(score<0)System.out.println("Not found");
        else System.out.println(score);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String name = input.next();
        getScore(name);
    }
    
}
