/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Chapter_39;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named(value = "timeBean")
@RequestScoped
public class TimeBean {

    public TimeBean() {
    }

    public String getTime() {
        return new java.util.Date().toString();
    }
}
