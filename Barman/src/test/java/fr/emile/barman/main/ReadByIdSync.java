package fr.emile.barman.main;

import fr.emile.barman.utils.Utils;
import fr.emile.barman.webservice.Exception_Exception;
import fr.emile.barman.webservice.Student;
import fr.emile.barman.webservice.StudentWebService;
import fr.emile.barman.webservice.StudentWebService_Service;

public class ReadByIdSync {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		StudentWebService_Service studentWebService = new StudentWebService_Service();
		StudentWebService studentWebPort =  studentWebService.getStudentWebServicePort();
		Student student = null ;
		int id = 3;
		
		try {
			student = studentWebPort.readStudentById(id);
		} catch (Exception_Exception e) {
			Utils.trace("catch error"+ e.toString());
			e.printStackTrace();
		}finally {
		
			Utils.trace(student.toString());
		}
	}
}
