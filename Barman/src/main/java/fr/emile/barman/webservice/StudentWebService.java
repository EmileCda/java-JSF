
package fr.emile.barman.webservice;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "StudentWebService", targetNamespace = "http://webservice.dove.emile.fr/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface StudentWebService {


    /**
     * 
     * @param arg0
     * @return
     *     returns fr.emile.barman.webservice.Student
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addStudent", targetNamespace = "http://webservice.dove.emile.fr/", className = "fr.emile.barman.webservice.AddStudent")
    @ResponseWrapper(localName = "addStudentResponse", targetNamespace = "http://webservice.dove.emile.fr/", className = "fr.emile.barman.webservice.AddStudentResponse")
    @Action(input = "http://webservice.dove.emile.fr/StudentWebService/addStudentRequest", output = "http://webservice.dove.emile.fr/StudentWebService/addStudentResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webservice.dove.emile.fr/StudentWebService/addStudent/Fault/Exception")
    })
    public Student addStudent(
        @WebParam(name = "arg0", targetNamespace = "")
        Student arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<fr.emile.barman.webservice.Student>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getStudent", targetNamespace = "http://webservice.dove.emile.fr/", className = "fr.emile.barman.webservice.GetStudent")
    @ResponseWrapper(localName = "getStudentResponse", targetNamespace = "http://webservice.dove.emile.fr/", className = "fr.emile.barman.webservice.GetStudentResponse")
    @Action(input = "http://webservice.dove.emile.fr/StudentWebService/getStudentRequest", output = "http://webservice.dove.emile.fr/StudentWebService/getStudentResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webservice.dove.emile.fr/StudentWebService/getStudent/Fault/Exception")
    })
    public List<Student> getStudent()
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns fr.emile.barman.webservice.Student
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getStudentById", targetNamespace = "http://webservice.dove.emile.fr/", className = "fr.emile.barman.webservice.GetStudentById")
    @ResponseWrapper(localName = "getStudentByIdResponse", targetNamespace = "http://webservice.dove.emile.fr/", className = "fr.emile.barman.webservice.GetStudentByIdResponse")
    @Action(input = "http://webservice.dove.emile.fr/StudentWebService/getStudentByIdRequest", output = "http://webservice.dove.emile.fr/StudentWebService/getStudentByIdResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webservice.dove.emile.fr/StudentWebService/getStudentById/Fault/Exception")
    })
    public Student getStudentById(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns fr.emile.barman.webservice.Student
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addEtudiant", targetNamespace = "http://webservice.dove.emile.fr/", className = "fr.emile.barman.webservice.AddEtudiant")
    @ResponseWrapper(localName = "addEtudiantResponse", targetNamespace = "http://webservice.dove.emile.fr/", className = "fr.emile.barman.webservice.AddEtudiantResponse")
    @Action(input = "http://webservice.dove.emile.fr/StudentWebService/addEtudiantRequest", output = "http://webservice.dove.emile.fr/StudentWebService/addEtudiantResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webservice.dove.emile.fr/StudentWebService/addEtudiant/Fault/Exception")
    })
    public Student addEtudiant(
        @WebParam(name = "arg0", targetNamespace = "")
        Student arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<fr.emile.barman.webservice.Student>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getEtudiant", targetNamespace = "http://webservice.dove.emile.fr/", className = "fr.emile.barman.webservice.GetEtudiant")
    @ResponseWrapper(localName = "getEtudiantResponse", targetNamespace = "http://webservice.dove.emile.fr/", className = "fr.emile.barman.webservice.GetEtudiantResponse")
    @Action(input = "http://webservice.dove.emile.fr/StudentWebService/getEtudiantRequest", output = "http://webservice.dove.emile.fr/StudentWebService/getEtudiantResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webservice.dove.emile.fr/StudentWebService/getEtudiant/Fault/Exception")
    })
    public List<Student> getEtudiant()
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns fr.emile.barman.webservice.Student
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getEtudiantById", targetNamespace = "http://webservice.dove.emile.fr/", className = "fr.emile.barman.webservice.GetEtudiantById")
    @ResponseWrapper(localName = "getEtudiantByIdResponse", targetNamespace = "http://webservice.dove.emile.fr/", className = "fr.emile.barman.webservice.GetEtudiantByIdResponse")
    @Action(input = "http://webservice.dove.emile.fr/StudentWebService/getEtudiantByIdRequest", output = "http://webservice.dove.emile.fr/StudentWebService/getEtudiantByIdResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webservice.dove.emile.fr/StudentWebService/getEtudiantById/Fault/Exception")
    })
    public Student getEtudiantById(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0)
        throws Exception_Exception
    ;

}