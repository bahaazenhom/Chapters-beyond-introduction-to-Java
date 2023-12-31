
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
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebService(name = "AddressService", targetNamespace = "http://chapter_41/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AddressService {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns myWebService.Address
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAddress", targetNamespace = "http://chapter_41/", className = "myWebService.GetAddress")
    @ResponseWrapper(localName = "getAddressResponse", targetNamespace = "http://chapter_41/", className = "myWebService.GetAddressResponse")
    @Action(input = "http://chapter_41/AddressService/getAddressRequest", output = "http://chapter_41/AddressService/getAddressResponse")
    public Address getAddress(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "initializeJdbc", targetNamespace = "http://chapter_41/", className = "myWebService.InitializeJdbc")
    @ResponseWrapper(localName = "initializeJdbcResponse", targetNamespace = "http://chapter_41/", className = "myWebService.InitializeJdbcResponse")
    @Action(input = "http://chapter_41/AddressService/initializeJdbcRequest", output = "http://chapter_41/AddressService/initializeJdbcResponse")
    public void initializeJdbc();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "storeAddress", targetNamespace = "http://chapter_41/", className = "myWebService.StoreAddress")
    @ResponseWrapper(localName = "storeAddressResponse", targetNamespace = "http://chapter_41/", className = "myWebService.StoreAddressResponse")
    @Action(input = "http://chapter_41/AddressService/storeAddressRequest", output = "http://chapter_41/AddressService/storeAddressResponse")
    public void storeAddress(
        @WebParam(name = "arg0", targetNamespace = "")
        Address arg0);

}
