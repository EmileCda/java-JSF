
package fr.emile.barman.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.emile.barman.webservice package. 
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

    private final static QName _HardDeleteStudent_QNAME = new QName("http://webservice.dove.emile.fr/", "hardDeleteStudent");
    private final static QName _Exception_QNAME = new QName("http://webservice.dove.emile.fr/", "Exception");
    private final static QName _ReadStudentById_QNAME = new QName("http://webservice.dove.emile.fr/", "readStudentById");
    private final static QName _CreateStudentResponse_QNAME = new QName("http://webservice.dove.emile.fr/", "createStudentResponse");
    private final static QName _ReadStudentByIdResponse_QNAME = new QName("http://webservice.dove.emile.fr/", "readStudentByIdResponse");
    private final static QName _DeleteStudentResponse_QNAME = new QName("http://webservice.dove.emile.fr/", "deleteStudentResponse");
    private final static QName _Student_QNAME = new QName("http://webservice.dove.emile.fr/", "student");
    private final static QName _UpdateStudentResponse_QNAME = new QName("http://webservice.dove.emile.fr/", "updateStudentResponse");
    private final static QName _UpdateStudent_QNAME = new QName("http://webservice.dove.emile.fr/", "updateStudent");
    private final static QName _DeleteStudent_QNAME = new QName("http://webservice.dove.emile.fr/", "deleteStudent");
    private final static QName _HardDeleteStudentResponse_QNAME = new QName("http://webservice.dove.emile.fr/", "hardDeleteStudentResponse");
    private final static QName _ReadStudentList_QNAME = new QName("http://webservice.dove.emile.fr/", "readStudentList");
    private final static QName _CreateStudent_QNAME = new QName("http://webservice.dove.emile.fr/", "createStudent");
    private final static QName _ReadStudentListResponse_QNAME = new QName("http://webservice.dove.emile.fr/", "readStudentListResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.emile.barman.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReadStudentById }
     * 
     */
    public ReadStudentById createReadStudentById() {
        return new ReadStudentById();
    }

    /**
     * Create an instance of {@link ReadStudentByIdResponse }
     * 
     */
    public ReadStudentByIdResponse createReadStudentByIdResponse() {
        return new ReadStudentByIdResponse();
    }

    /**
     * Create an instance of {@link CreateStudentResponse }
     * 
     */
    public CreateStudentResponse createCreateStudentResponse() {
        return new CreateStudentResponse();
    }

    /**
     * Create an instance of {@link DeleteStudentResponse }
     * 
     */
    public DeleteStudentResponse createDeleteStudentResponse() {
        return new DeleteStudentResponse();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link UpdateStudentResponse }
     * 
     */
    public UpdateStudentResponse createUpdateStudentResponse() {
        return new UpdateStudentResponse();
    }

    /**
     * Create an instance of {@link UpdateStudent }
     * 
     */
    public UpdateStudent createUpdateStudent() {
        return new UpdateStudent();
    }

    /**
     * Create an instance of {@link HardDeleteStudent }
     * 
     */
    public HardDeleteStudent createHardDeleteStudent() {
        return new HardDeleteStudent();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link ReadStudentListResponse }
     * 
     */
    public ReadStudentListResponse createReadStudentListResponse() {
        return new ReadStudentListResponse();
    }

    /**
     * Create an instance of {@link DeleteStudent }
     * 
     */
    public DeleteStudent createDeleteStudent() {
        return new DeleteStudent();
    }

    /**
     * Create an instance of {@link HardDeleteStudentResponse }
     * 
     */
    public HardDeleteStudentResponse createHardDeleteStudentResponse() {
        return new HardDeleteStudentResponse();
    }

    /**
     * Create an instance of {@link ReadStudentList }
     * 
     */
    public ReadStudentList createReadStudentList() {
        return new ReadStudentList();
    }

    /**
     * Create an instance of {@link CreateStudent }
     * 
     */
    public CreateStudent createCreateStudent() {
        return new CreateStudent();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HardDeleteStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "hardDeleteStudent")
    public JAXBElement<HardDeleteStudent> createHardDeleteStudent(HardDeleteStudent value) {
        return new JAXBElement<HardDeleteStudent>(_HardDeleteStudent_QNAME, HardDeleteStudent.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadStudentById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "readStudentById")
    public JAXBElement<ReadStudentById> createReadStudentById(ReadStudentById value) {
        return new JAXBElement<ReadStudentById>(_ReadStudentById_QNAME, ReadStudentById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "createStudentResponse")
    public JAXBElement<CreateStudentResponse> createCreateStudentResponse(CreateStudentResponse value) {
        return new JAXBElement<CreateStudentResponse>(_CreateStudentResponse_QNAME, CreateStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadStudentByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "readStudentByIdResponse")
    public JAXBElement<ReadStudentByIdResponse> createReadStudentByIdResponse(ReadStudentByIdResponse value) {
        return new JAXBElement<ReadStudentByIdResponse>(_ReadStudentByIdResponse_QNAME, ReadStudentByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "deleteStudentResponse")
    public JAXBElement<DeleteStudentResponse> createDeleteStudentResponse(DeleteStudentResponse value) {
        return new JAXBElement<DeleteStudentResponse>(_DeleteStudentResponse_QNAME, DeleteStudentResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "updateStudentResponse")
    public JAXBElement<UpdateStudentResponse> createUpdateStudentResponse(UpdateStudentResponse value) {
        return new JAXBElement<UpdateStudentResponse>(_UpdateStudentResponse_QNAME, UpdateStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "updateStudent")
    public JAXBElement<UpdateStudent> createUpdateStudent(UpdateStudent value) {
        return new JAXBElement<UpdateStudent>(_UpdateStudent_QNAME, UpdateStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "deleteStudent")
    public JAXBElement<DeleteStudent> createDeleteStudent(DeleteStudent value) {
        return new JAXBElement<DeleteStudent>(_DeleteStudent_QNAME, DeleteStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HardDeleteStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "hardDeleteStudentResponse")
    public JAXBElement<HardDeleteStudentResponse> createHardDeleteStudentResponse(HardDeleteStudentResponse value) {
        return new JAXBElement<HardDeleteStudentResponse>(_HardDeleteStudentResponse_QNAME, HardDeleteStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadStudentList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "readStudentList")
    public JAXBElement<ReadStudentList> createReadStudentList(ReadStudentList value) {
        return new JAXBElement<ReadStudentList>(_ReadStudentList_QNAME, ReadStudentList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "createStudent")
    public JAXBElement<CreateStudent> createCreateStudent(CreateStudent value) {
        return new JAXBElement<CreateStudent>(_CreateStudent_QNAME, CreateStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadStudentListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.dove.emile.fr/", name = "readStudentListResponse")
    public JAXBElement<ReadStudentListResponse> createReadStudentListResponse(ReadStudentListResponse value) {
        return new JAXBElement<ReadStudentListResponse>(_ReadStudentListResponse_QNAME, ReadStudentListResponse.class, null, value);
    }

}
