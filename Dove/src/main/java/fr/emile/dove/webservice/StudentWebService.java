package fr.emile.dove.webservice;

import java.util.List;

import javax.jws.WebService;

import fr.emile.dove.entity.Student;
import fr.emile.dove.model.implement.StudentDao;
import fr.emile.dove.utils.Utils;

@WebService(endpointInterface = "fr.emile.dove.webservice.StudentWebService", 
serviceName = "StudentWebService", portName = "StudentWebServicePort")
public class StudentWebService implements IStudentWebService {

	
	

	public Student createStudent(Student student) throws Exception {
		Utils.trace(student.toString());
		if (student==null) throw new NullPointerException("Student null");
		if (!student.isCorrect())
			throw new IllegalArgumentException("Student not correct : "+ student.toString());
		StudentDao myStudentDao = new StudentDao();
		student=myStudentDao.add(student);
		return student;
	}

	public List<Student> readStudentList() throws Exception {
		StudentDao myStudentDao = new StudentDao();
		return myStudentDao.get();
	}

	public Student readStudentById(Integer id) throws Exception {
		StudentDao myStudentDao = new StudentDao();
		Utils.trace("readStudentById");
		return myStudentDao.get(id);
	}

	@Override
	public int updateStudent(Student student) throws Exception {
		StudentDao myStudentDao = new StudentDao();
		Utils.trace(student.toString());
		return myStudentDao.update(student);
	}

	@Override
	public int deleteStudent(Integer id) throws Exception {
		StudentDao myStudentDao = new StudentDao();
		return myStudentDao.delete(id);
	}
	@Override
	public int hardDeleteStudent(Integer id) throws Exception {
		StudentDao myStudentDao = new StudentDao();
		return myStudentDao.remove (myStudentDao.get(id));
	}


}
