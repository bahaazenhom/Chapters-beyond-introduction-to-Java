/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chapter_38;
import java.text.*;

/**
 *
 * @author bahaa
 */
public class FactorialBean {

    private int number;

    /**
     * Return number property
     */
    public int getNumber() {
        return number;
    }

    /**
     * Set number property
     */
    public void setNumber(int newValue) {
        number = newValue;
    }

    /**
     * Obtain factorial
     */
    public long getFactorial() {
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static String format(long number) {
        NumberFormat format = NumberFormat.getNumberInstance();
        return format.format(number);
    }
}
