package fr.emile.dove.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.emile.dove.entity.Student;

@WebService(name="StudentWebService", targetNamespace ="http://webservice.dove.emile.fr" )
public interface IStudentWebService {
	

	@WebMethod
	Student createStudent(@WebParam(name="student") Student student) throws Exception;
	
	@WebMethod
	Student readStudentById(@WebParam(name="id") Integer id) throws Exception;
	@WebMethod
	List<Student> readStudentList() throws Exception;
	
	@WebMethod
	int updateStudent(@WebParam(name="student") Student student) throws Exception;
	@WebMethod
	int deleteStudent(@WebParam(name="id") Integer id) throws Exception;
	
	@WebMethod
	int hardDeleteStudent(@WebParam(name="id") Integer id) throws Exception;

}
