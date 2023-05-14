package fr.emile.dove.test;

import java.util.ArrayList;
import java.util.List;

import fr.emile.dove.entity.Student;
import fr.emile.dove.model.implement.StudentDao;
import fr.emile.dove.utils.Utils;

public class StudentRetreive {

	public static void main(String[] args) {

		
		StudentDao myStudentDao = new StudentDao();
		List<Student> studentList = new ArrayList<Student>(); 
				
		try {
			studentList= myStudentDao.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			
			for (Student student : studentList) {
				Utils.trace(student.toString());
				
			}
		}
		
		
		
		
	}

}
