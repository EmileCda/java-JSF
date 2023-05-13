package fr.emile.dove.webservice;

import java.util.List;

import javax.jws.WebService;

import fr.emile.dove.entity.Student;
import fr.emile.dove.model.implement.StudentDao;
import fr.emile.dove.utils.Utils;

@WebService(endpointInterface = "fr.emile.dove.webservice.StudentWebService", 
serviceName = "StudentWebService", portName = "StudentWebServicePort")
public class StudentWebService implements IStudentWebService {

	
	

	public Student addStudent(Student student) throws Exception {
		Utils.trace(student.toString());
		if (student==null) throw new NullPointerException("Student null");
		if (!student.isCorrect())
			throw new IllegalArgumentException("Student not correct : "+ student.toString());
		
		
		StudentDao myStudentDao = new StudentDao();
		student=myStudentDao.add(student);
		return student;
	}

	public List<Student> getStudent() throws Exception {
		StudentDao myStudentDao = new StudentDao();
		return myStudentDao.get();
	}

	public Student getStudentById(Integer id) throws Exception {
		StudentDao myStudentDao = new StudentDao();
		return myStudentDao.get(id);
	}

	@Override
	public Student addEtudiant(Student etudiant) throws Exception {
		return addStudent(etudiant);
	}

	@Override
	public List<Student> getEtudiant() throws Exception {
		return getStudent();
	}

	@Override
	public Student getEtudiantById(Integer id) throws Exception {
		return getStudentById(id);
	}

}
