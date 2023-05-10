package fr.emile.dove.webservice;

import java.util.List;

import javax.jws.WebService;

import fr.emile.dove.entity.Student;

@WebService(endpointInterface = "fr.emile.dove.webservice.StudentWebService", serviceName = "StudentWebService", portName = "StudentPort")
public class StudentWebService implements IStudentWebService {

	@Override
	public Student addStudent(Student student) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudent() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudentZ(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student addEtudiant(Student etudiant) throws Exception {
		return addStudent(etudiant) ;
	}

	@Override
	public List<Student> getEtudiant() throws Exception {
		return getStudent();
	}

	@Override
	public Student getEtudiantById(Integer id) throws Exception {
		return getStudentZ( id) ;
	}

}
