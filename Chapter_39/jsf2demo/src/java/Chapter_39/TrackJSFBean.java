/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Chapter_39;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.*;

/**
 *
 * @author bahaa
 */
@Named(value = "trackJSFBean")
@ApplicationScoped
public class TrackJSFBean {
    private Map<String,Integer> map = new HashMap<>();
    /**
     * Creates a new instance of TrackJSFBean
     */
    public TrackJSFBean() {
    }
    public void add(String ipAddress){
        map.put(ipAddress, map.containsKey(ipAddress)?map.get(ipAddress)+1:1);
    }
    public int getCount(String ipAddress){
        return map.containsKey(ipAddress)?map.get(ipAddress):0;
    }
    public String getAllCount(){
        return "Count summary is "+map;
    }
}
