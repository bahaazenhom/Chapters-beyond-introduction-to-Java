
package myWebService;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "AddressWebService", targetNamespace = "http://chapter_41/", wsdlLocation = "http://localhost:8080/WebServiceProject/AddressWebService?WSDL")
public class AddressWebService
    extends Service
{

    private final static URL ADDRESSWEBSERVICE_WSDL_LOCATION;
    private final static WebServiceException ADDRESSWEBSERVICE_EXCEPTION;
    private final static QName ADDRESSWEBSERVICE_QNAME = new QName("http://chapter_41/", "AddressWebService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/WebServiceProject/AddressWebService?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ADDRESSWEBSERVICE_WSDL_LOCATION = url;
        ADDRESSWEBSERVICE_EXCEPTION = e;
    }

    public AddressWebService() {
        super(__getWsdlLocation(), ADDRESSWEBSERVICE_QNAME);
    }

    public AddressWebService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ADDRESSWEBSERVICE_QNAME, features);
    }

    public AddressWebService(URL wsdlLocation) {
        super(wsdlLocation, ADDRESSWEBSERVICE_QNAME);
    }

    public AddressWebService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ADDRESSWEBSERVICE_QNAME, features);
    }

    public AddressWebService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AddressWebService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AddressService
     */
    @WebEndpoint(name = "AddressServicePort")
    public AddressService getAddressServicePort() {
        return super.getPort(new QName("http://chapter_41/", "AddressServicePort"), AddressService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AddressService
     */
    @WebEndpoint(name = "AddressServicePort")
    public AddressService getAddressServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://chapter_41/", "AddressServicePort"), AddressService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ADDRESSWEBSERVICE_EXCEPTION!= null) {
            throw ADDRESSWEBSERVICE_EXCEPTION;
        }
        return ADDRESSWEBSERVICE_WSDL_LOCATION;
    }

}
