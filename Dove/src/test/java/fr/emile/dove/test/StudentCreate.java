package fr.emile.dove.test;

import fr.emile.dove.entity.DataTest;
import fr.emile.dove.entity.Student;
import fr.emile.dove.model.implement.StudentDao;
import fr.emile.dove.model.interfaces.IStudentDao;
import fr.emile.dove.utils.Utils;

public class StudentCreate {

	
	public static void main(String[] args) {
		
		Student myStudent;
		myStudent = DataTest.genStudent();
		Utils.trace(myStudent.toString());
		
		
		IStudentDao myUserDao = new StudentDao();
		
		
		try {
			for (int index = 0 ; index < 10 ; index ++) {
				myStudent = DataTest.genStudent();
				myUserDao.add(myStudent);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Utils.trace("exception"+ e.toString() + " " + myStudent.toString());
			e.printStackTrace();
		}
		
		
		
		Utils.trace("================== end ================== ");
		
		
	}
}
