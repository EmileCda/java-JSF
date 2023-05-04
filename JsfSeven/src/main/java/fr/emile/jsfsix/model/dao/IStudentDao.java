package fr.emile.jsfsix.model.dao;

import java.util.List;


import fr.emile.jsfsix.entity.Student;



public interface IStudentDao {
	Student add(Student stude) throws Exception;
	Student get(int id) throws Exception;
	List<Student> get() throws Exception;
	int Update(Student person)throws Exception;
	int delete (int id,boolean isDeleted)throws Exception;
	int delete (Student person,boolean isDeleted)throws Exception;
	int delete (int id)throws Exception;
	int delete (Student person)throws Exception;

}
