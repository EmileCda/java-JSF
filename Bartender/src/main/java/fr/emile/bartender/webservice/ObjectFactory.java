
package fr.emile.bartender.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.emile.dove.webservice package. 
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

    private final static QName _GetStudentByIdResponse_QNAME = new QName("http://webservice.dove.emile.fr/", "getStudentByIdResponse");
    private final static QName _AddEtudiantResponse_QNAME = new QName("http://webservice.dove.emile.fr/", "addEtudiantResponse");
    private final static QName _AddEtudiant_QNAME = new QName("http://webservice.dove.emile.fr/", "addEtudiant");
    private final static QName _GetEtudiant_QNAME = new QName("http://webservice.dove.emile.fr/", "getEtudiant");
    private final static QName _Exception_QNAME = new QName("http://webservice.dove.emile.fr/", "Exception");
    private final static QName _GetStudent_QNAME = new QName("http://webservice.dove.emile.fr/", "getStudent");
    private final static QName _AddStudent_QNAME = new QName("http://webservice.dove.emile.fr/", "addStudent");
    private final static QName _GetEtudiantById_QNAME = new QName("http://webservice.dove.emile.fr/", "getEtudiantById");
    private final static QName _GetEtudiantByIdResponse_QNAME = new QName("http://webservice.dove.emile.fr/", "getEtudiantByIdResponse");
    private final static QName _Student_QNAME = new QName("http://webservice.dove.emile.fr/", "student");
    private final static QName _AddStudentResponse_QNAME = new QName("http://webservice.dove.emile.fr/", "addStudentResponse");
    private final static QName _GetEtudiantResponse_QNAME = new QName("http://webservice.dove.emile.fr/", "getEtudiantResponse");
    private final static QName _GetStudentResponse_QNAME = new QName("http://webservice.dove.emile.fr/", "getStudentResponse");
    private final static QName _GetStudentById_QNAME = new QName("http://webservice.dove.emile.fr/", "getStudentById");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.emile.dove.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddStudent }
     * 
     */
    public AddStudent createAddStudent() {
        return new AddStudent();
    }

    /**
     * Create an instance of {@link GetEtudiantById }
     * 
     */
    public GetEtudiantById createGetEtudiantById() {
        return new GetEtudiantById();
    }

    /**
     * Create an instance of {@link GetEtudiantByIdResponse }
     * 
     */
    public GetEtudiantByIdResponse createGetEtudiantByIdResponse() {
        return new GetEtudiantByIdResponse();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link GetStudentByIdResponse }
     * 
     */
    public GetStudentByIdResponse createGetStudentByIdResponse() {
        return new GetStudentByIdResponse();
    }

    /**
     * Create an instance of {@link AddEtudiantResponse }
     * 
     */
    public AddEtudiantResponse createAddEtudiantResponse() {
        return new AddEtudiantResponse();
    }

    /**
     * Create an instance of {@link AddEtudiant }
     * 
     */
    public AddEtudiant createAddEtudiant() {
        return new AddEtudiant();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link GetStudent }
     * 
     */
    public GetStudent createGetStudent() {
        return new GetStudent();
    }

    /**
     * Create an instance of {@link GetEtudiant }
     * 
     */
    public GetEtudiant createGetEtudiant() {
        return new GetEtudiant();
    }

    /**
     * Create an instance of {@link GetEtudiantResponse }
     * 
     */
    public GetEtudiantResponse createGetEtudiantResponse() {
        return new GetEtudiantResponse();
    }

    /**
     * Create an instance of {@link GetStudentResponse }
     * 
     */
    public GetStudentResponse createGetStudentResponse() {
        return new GetStudentResponse();
    }

    /**
     * Create an instance of {@link GetStudentById }
     * 
     */
    public GetStudentById createGetStudentById() {
        return new GetStudentById();
    }

    /**
     * Create an instance of {@link AddStudentResponse }
     * 
     */
    public AddStudentResponse createAddStudentResponse() {
        return new AddStudentResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "getStudentByIdResponse")
    public JAXBElement<GetStudentByIdResponse> createGetStudentByIdResponse(GetStudentByIdResponse value) {
        return new JAXBElement<GetStudentByIdResponse>(_GetStudentByIdResponse_QNAME, GetStudentByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEtudiantResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "addEtudiantResponse")
    public JAXBElement<AddEtudiantResponse> createAddEtudiantResponse(AddEtudiantResponse value) {
        return new JAXBElement<AddEtudiantResponse>(_AddEtudiantResponse_QNAME, AddEtudiantResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEtudiant }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "addEtudiant")
    public JAXBElement<AddEtudiant> createAddEtudiant(AddEtudiant value) {
        return new JAXBElement<AddEtudiant>(_AddEtudiant_QNAME, AddEtudiant.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEtudiant }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "getEtudiant")
    public JAXBElement<GetEtudiant> createGetEtudiant(GetEtudiant value) {
        return new JAXBElement<GetEtudiant>(_GetEtudiant_QNAME, GetEtudiant.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "getStudent")
    public JAXBElement<GetStudent> createGetStudent(GetStudent value) {
        return new JAXBElement<GetStudent>(_GetStudent_QNAME, GetStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "addStudent")
    public JAXBElement<AddStudent> createAddStudent(AddStudent value) {
        return new JAXBElement<AddStudent>(_AddStudent_QNAME, AddStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEtudiantById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "getEtudiantById")
    public JAXBElement<GetEtudiantById> createGetEtudiantById(GetEtudiantById value) {
        return new JAXBElement<GetEtudiantById>(_GetEtudiantById_QNAME, GetEtudiantById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEtudiantByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "getEtudiantByIdResponse")
    public JAXBElement<GetEtudiantByIdResponse> createGetEtudiantByIdResponse(GetEtudiantByIdResponse value) {
        return new JAXBElement<GetEtudiantByIdResponse>(_GetEtudiantByIdResponse_QNAME, GetEtudiantByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Student }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "student")
    public JAXBElement<Student> createStudent(Student value) {
        return new JAXBElement<Student>(_Student_QNAME, Student.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "addStudentResponse")
    public JAXBElement<AddStudentResponse> createAddStudentResponse(AddStudentResponse value) {
        return new JAXBElement<AddStudentResponse>(_AddStudentResponse_QNAME, AddStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEtudiantResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "getEtudiantResponse")
    public JAXBElement<GetEtudiantResponse> createGetEtudiantResponse(GetEtudiantResponse value) {
        return new JAXBElement<GetEtudiantResponse>(_GetEtudiantResponse_QNAME, GetEtudiantResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "getStudentResponse")
    public JAXBElement<GetStudentResponse> createGetStudentResponse(GetStudentResponse value) {
        return new JAXBElement<GetStudentResponse>(_GetStudentResponse_QNAME, GetStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "getStudentById")
    public JAXBElement<GetStudentById> createGetStudentById(GetStudentById value) {
        return new JAXBElement<GetStudentById>(_GetStudentById_QNAME, GetStudentById.class, null, value);
    }

}
