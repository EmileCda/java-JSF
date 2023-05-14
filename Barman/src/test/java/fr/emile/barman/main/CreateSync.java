package fr.emile.barman.main;

import fr.emile.barman.utils.Utils;
import fr.emile.barman.webservice.Exception_Exception;
import fr.emile.barman.webservice.Student;
import fr.emile.barman.webservice.StudentWebService;
import fr.emile.barman.webservice.StudentWebService_Service;

public class CreateSync {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		StudentWebService_Service studentWebService = new StudentWebService_Service();
		StudentWebService studentWebPort =  studentWebService.getStudentWebServicePort();
		
		Student studentToAdd = new Student();
		Student studentAdded = null ; 
		studentToAdd= DataTest.genStudent();
	
		

		try {
			studentAdded = studentWebPort.createStudent(studentToAdd);
		} catch (Exception_Exception e) {
			Utils.trace("catch error"+ e.toString());
			e.printStackTrace();
		}finally {
		
			if (studentAdded != null )
				Utils.trace(studentAdded.toString());
		}
	}
}
