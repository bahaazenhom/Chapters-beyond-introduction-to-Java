
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

    private final static QName _GradeQuiz_QNAME = new QName("http://chapter_41/", "gradeQuiz");
    private final static QName _GradeQuizResponse_QNAME = new QName("http://chapter_41/", "gradeQuizResponse");
    private final static QName _GetQuestions_QNAME = new QName("http://chapter_41/", "getQuestions");
    private final static QName _GetQuestionsResponse_QNAME = new QName("http://chapter_41/", "getQuestionsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: myWebService
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GradeQuizResponse }
     * 
     */
    public GradeQuizResponse createGradeQuizResponse() {
        return new GradeQuizResponse();
    }

    /**
     * Create an instance of {@link GetQuestions }
     * 
     */
    public GetQuestions createGetQuestions() {
        return new GetQuestions();
    }

    /**
     * Create an instance of {@link GetQuestionsResponse }
     * 
     */
    public GetQuestionsResponse createGetQuestionsResponse() {
        return new GetQuestionsResponse();
    }

    /**
     * Create an instance of {@link GradeQuiz }
     * 
     */
    public GradeQuiz createGradeQuiz() {
        return new GradeQuiz();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GradeQuiz }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chapter_41/", name = "gradeQuiz")
    public JAXBElement<GradeQuiz> createGradeQuiz(GradeQuiz value) {
        return new JAXBElement<GradeQuiz>(_GradeQuiz_QNAME, GradeQuiz.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GradeQuizResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chapter_41/", name = "gradeQuizResponse")
    public JAXBElement<GradeQuizResponse> createGradeQuizResponse(GradeQuizResponse value) {
        return new JAXBElement<GradeQuizResponse>(_GradeQuizResponse_QNAME, GradeQuizResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chapter_41/", name = "getQuestions")
    public JAXBElement<GetQuestions> createGetQuestions(GetQuestions value) {
        return new JAXBElement<GetQuestions>(_GetQuestions_QNAME, GetQuestions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chapter_41/", name = "getQuestionsResponse")
    public JAXBElement<GetQuestionsResponse> createGetQuestionsResponse(GetQuestionsResponse value) {
        return new JAXBElement<GetQuestionsResponse>(_GetQuestionsResponse_QNAME, GetQuestionsResponse.class, null, value);
    }

}
