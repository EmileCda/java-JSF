package fr.emile.bartender.main;



import javax.xml.ws.Response;


import fr.emile.bartender.utils.Utils;
import fr.emile.bartender.webservice.CreateStudentResponse;
import fr.emile.bartender.webservice.Student;
import fr.emile.bartender.webservice.StudentWebService;
import fr.emile.bartender.webservice.StudentWebService_Service;

public class CreatePoolingAsync {

	public static void main(String[] args) {
		// 
		StudentWebService_Service studentWebService = new StudentWebService_Service();
		StudentWebService studentWebPort =  studentWebService.getStudentWebServicePort();
		
		Student studentToAdd = new Student();
		studentToAdd= DataTest.genStudent();
		
		Student studentAdded = null ;
		
		try {
			Utils.trace(" with pooling" );
			Response<CreateStudentResponse> response = studentWebPort.createStudentAsync(studentToAdd);
			Thread.sleep(2000);
			CreateStudentResponse output = response.get();
			Utils.trace(String.format(" student : %s added by pooling ", output.getReturn().toString() ));
			
			
		} catch (Exception exception) {

			Utils.trace(String.format("%s pooling for response %s ", 
									exception.getClass().getName(),
									exception.getMessage()));
		}
		

	}
}