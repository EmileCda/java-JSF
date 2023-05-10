package fr.emile.dove.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.emile.dove.entity.Student;

@WebService(name="StudentService", targetNamespace ="http://webservice.dove.emile.fr" )
public interface IStudentWebService {
	
	@WebMethod
	Student addStudent(@WebParam(name="student") Student student) throws Exception;
	
	@WebMethod
	List<Student> getStudent() throws Exception;

	@WebMethod
	Student getStudentZ(@WebParam(name="id") Integer id) throws Exception;


	@WebMethod
	Student addEtudiant(@WebParam(name="etudiant") Student etudiant) throws Exception;
	
	@WebMethod
	List<Student> getEtudiant() throws Exception;

	@WebMethod
	Student getEtudiantById(@WebParam(name="id") Integer id) throws Exception;


}
