/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Chapter_39;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author bahaa
 */
@Named(value = "guessNumberJSFBean")
@RequestScoped
public class GuessNumberJSFBean implements Serializable{
    private int number;
    private String guessString;
    /**
     * Creates a new instance of GuessNumberJSFBean
     */
    public GuessNumberJSFBean() {
        number = (int)(Math.random()*100);
    }
    public String getGuessString(){
        return guessString;
    }
    public void setGuessString(String guessString){
        this.guessString = guessString;
    }
    public String getResponse(){
        if(guessString == null)return "";
        int guess = Integer.parseInt(guessString);
        if(guess<number)return "Too low";
        else if(guess == number) return "You got it";
        return "Too high";
}
    public String getNumber(){
        return number+"";
    }
}