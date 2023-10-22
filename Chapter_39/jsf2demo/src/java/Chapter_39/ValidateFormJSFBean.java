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
@Named(value = "validateForm")
@RequestScoped
public class ValidateFormJSFBean {

    private String name;
    private String ssn;
    private String ageString;
    private String heightString;

    /**
     * Creates a new instance of ValidateFormJSFBean
     */
    public ValidateFormJSFBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getAgeString() {
        return ageString;
    }

    public void setAgeString(String ageString) {
        this.ageString = ageString;
    }

    public String getHeightString() {
        return heightString;
    }

    public void setHeightString(String heightString) {
        this.heightString = heightString;
    }

    public String getResponse() {
        if (name == null || ssn == null || ageString == null
                || heightString == null) {
            return "";
        } else {
            return "You entered "
                    + " Name: " + name
                    + " SSN: " + ssn
                    + " Age: " + ageString
                    + " Height: " + heightString;
        }
    }

}
