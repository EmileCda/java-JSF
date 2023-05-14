package fr.emile.dove.model.interfaces;

import java.util.List;
import java.util.Map;

import fr.emile.dove.entity.Student;

public interface IStudentDao {
	
	Student add(Student student) throws Exception;
	Student get(int id) throws Exception;
	Student get(String email) throws Exception;// get student by email
	List<Student> get() throws Exception;
	int update(Student student)throws Exception;
	int delete (int id,boolean isDeleted)throws Exception;
	int delete (Student student,boolean isDeleted)throws Exception;
	int delete (int id)throws Exception;
	int delete (Student student)throws Exception;
	int remove(Student student) throws Exception;

}
