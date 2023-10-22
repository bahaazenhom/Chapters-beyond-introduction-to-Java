
package myWebService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.5
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ScoreService", targetNamespace = "http://chapter_41/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ScoreService {


    /**
     * 
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findScore", targetNamespace = "http://chapter_41/", className = "myWebService.FindScore")
    @ResponseWrapper(localName = "findScoreResponse", targetNamespace = "http://chapter_41/", className = "myWebService.FindScoreResponse")
    @Action(input = "http://chapter_41/ScoreService/findScoreRequest", output = "http://chapter_41/ScoreService/findScoreResponse")
    public double findScore(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}