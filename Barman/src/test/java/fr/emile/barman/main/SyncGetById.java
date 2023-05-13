package fr.emile.barman.main;

import fr.emile.barman.utils.Utils;
import fr.emile.barman.webservice.Student;
import fr.emile.barman.webservice.StudentWebService;
import fr.emile.barman.webservice.StudentWebService_Service;

public class SyncGetById {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		StudentWebService_Service studentWebService = new StudentWebService_Service();
		StudentWebService studentWebPort =  studentWebService.getStudentWebServicePort();
		
		Student student = null ;
		int id = 100;
		
		
		try {
			student = studentWebPort.getStudentById(id);
		} catch (Exception e) {
			// next version add sql exception  and exception when retunr null 
			Utils.trace("catch error :"+ e.toString());
			e.printStackTrace();
		}finally {
		
			if (student != null)
				Utils.trace(student.toString());
			else
				Utils.trace(String.format("student with id: %s not found", id));
				
		}
	}

}
