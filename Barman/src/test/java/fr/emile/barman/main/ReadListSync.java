package fr.emile.barman.main;

import java.util.ArrayList;
import java.util.List;

import fr.emile.barman.utils.Utils;
import fr.emile.barman.webservice.Exception_Exception;
import fr.emile.barman.webservice.Student;
import fr.emile.barman.webservice.StudentWebService;
import fr.emile.barman.webservice.StudentWebService_Service;

public class ReadListSync {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		StudentWebService_Service studentWebService = new StudentWebService_Service();
		StudentWebService studentWebPort =  studentWebService.getStudentWebServicePort();
		List<Student> studentList = null ;
		int id = 3;
		
		try {
			studentList = new ArrayList<Student>();
			studentList= studentWebPort.readStudentList();
		} catch (Exception_Exception e) {
			Utils.trace("catch error"+ e.toString());
			e.printStackTrace();
		}finally {
		
			for (Student student : studentList) {
				Utils.trace(student.toString());
			}
			
		}
	}
}
