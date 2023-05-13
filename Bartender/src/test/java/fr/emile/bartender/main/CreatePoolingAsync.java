package fr.emile.bartender.main;


import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;


import fr.emile.bartender.utils.Utils;
import fr.emile.bartender.webservice.AddStudentResponse;
import fr.emile.bartender.webservice.Student;
import fr.emile.bartender.webservice.StudentWebService;
import fr.emile.bartender.webservice.StudentWebService_Service;

public class AsyncAdd {

	public static void main(String[] args) {
		// 
		StudentWebService_Service studentWebService = new StudentWebService_Service();
		StudentWebService studentWebPort =  studentWebService.getStudentWebServicePort();
		
		Student studentToAdd = new Student();
		String firstname = DataTest.firstname();
		String lastname = DataTest.lastname();
		studentToAdd.setFirstname(firstname);
		studentToAdd.setLastname(lastname);
		studentToAdd.setEmail(DataTest.email(firstname, lastname));
		studentToAdd.setSpeciality(DataTest.specialite());
		studentToAdd.setAge(DataTest.age(18, 80));
		
		Student studentAdded = null ;
		
		AsyncHandler<AddStudentResponse> asyncHandler = new AsyncHandler<AddStudentResponse>() {
			public void handleResponse(Response<AddStudentResponse>  response) {
				Utils.trace(" in handler response" );
				if (!response.isCancelled()&& response.isDone()) {
				
					try {
						Student studentAdded = response.get().getReturn();
						Utils.trace(String.format(" student : %s added", studentAdded.toString() ));
						
					} catch (Exception exception) {
						Utils.trace(String.format("%s callback for response %s ", 
								exception.getClass().getName(),
								exception.getMessage()));
					}
				
				}
	
			}
		};
		Utils.trace(" with callback" );
		studentWebPort.addStudentAsync(studentToAdd,asyncHandler);
		Utils.trace(" done with callback" );
		
		
		studentToAdd = new Student();
		firstname = DataTest.firstname();
		lastname = DataTest.lastname();
		studentToAdd.setFirstname(firstname);
		studentToAdd.setLastname(lastname);
		studentToAdd.setEmail(DataTest.email(firstname, lastname));
		studentToAdd.setSpeciality(DataTest.specialite());
		studentToAdd.setAge(DataTest.age(18, 80));
		
		try {
			Utils.trace(" with pooling" );
			Response<AddStudentResponse> response = studentWebPort.addStudentAsync(studentToAdd);
			Thread.sleep(2000);
			AddStudentResponse output = response.get();
			Utils.trace(String.format(" student : %s added by pooling ", output.getReturn().toString() ));
			
			
		} catch (Exception exception) {

			Utils.trace(String.format("%s pooling for response %s ", 
									exception.getClass().getName(),
									exception.getMessage()));
		}
		

	}
}