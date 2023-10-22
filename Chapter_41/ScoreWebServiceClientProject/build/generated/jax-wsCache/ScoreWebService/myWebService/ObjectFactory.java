
package myWebService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the myWebService package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindScore_QNAME = new QName("http://chapter_41/", "findScore");
    private final static QName _FindScoreResponse_QNAME = new QName("http://chapter_41/", "findScoreResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: myWebService
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindScore }
     * 
     */
    public FindScore createFindScore() {
        return new FindScore();
    }

    /**
     * Create an instance of {@link FindScoreResponse }
     * 
     */
    public FindScoreResponse createFindScoreResponse() {
        return new FindScoreResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindScore }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindScore }{@code >}
     */
    @XmlElementDecl(namespace = "http://chapter_41/", name = "findScore")
    public JAXBElement<FindScore> createFindScore(FindScore value) {
        return new JAXBElement<FindScore>(_FindScore_QNAME, FindScore.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindScoreResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindScoreResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://chapter_41/", name = "findScoreResponse")
    public JAXBElement<FindScoreResponse> createFindScoreResponse(FindScoreResponse value) {
        return new JAXBElement<FindScoreResponse>(_FindScoreResponse_QNAME, FindScoreResponse.class, null, value);
    }

}
