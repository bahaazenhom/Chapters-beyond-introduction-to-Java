/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Chapter_39;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

/**
 *
 * @author bahaa
 */
@Named(value = "calculator")
@RequestScoped
public class CalculatorJSFBean {

    private double number1;
    private double number2;
    private double result;

    /**
     * Creates a new instance of CalculatorJSFBean
     */
    public CalculatorJSFBean() {
    }

    public double getNumber1() {
        return number1;
    }

    public double getNumber2() {
        return number2;
    }

    public double getResult() {
        return result;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void add() {
        result = number1 + number2;
    }

    public void subtract() {
        result = number1 - number2;
    }

    public void multiply() {
        result = number1 * number2;
    }

    public void divide() {
        result = number1 / number2;
    }

}
