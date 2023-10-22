/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Chapter_39;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author bahaa
 */
@Named(value = "track")
@ApplicationScoped
public class Track implements Serializable{

    private Map<String, Integer> mp = new HashMap<>();

    String ipAddress;

    public Track() {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        this.ipAddress = request.getRemoteAddr()+100*Math.random();
    }

    public void add() {
        mp.put(ipAddress, mp.containsKey(ipAddress) ? mp.get(ipAddress) + 1 : 1);
    }

    public int getCount() {
        return mp.containsKey(ipAddress) ? mp.get(ipAddress) : 0;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getAllCount() {
        return "Count summary is " + mp;
    }

}
