package fr.emile.bartender.main;




import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;


import fr.emile.bartender.utils.Utils;
import fr.emile.bartender.webservice.CreateStudentResponse;
import fr.emile.bartender.webservice.Student;
import fr.emile.bartender.webservice.StudentWebService;
import fr.emile.bartender.webservice.StudentWebService_Service;


public class CreateCallBackAsync {

	public static void main(String[] args) {
		// 
		StudentWebService_Service studentWebService = new StudentWebService_Service();
		StudentWebService studentWebPort =  studentWebService.getStudentWebServicePort();
		Student studentToAdd = new Student();
		studentToAdd= DataTest.genStudent();
		
		//Asynchrone with callback handler (event)
		AsyncHandler<CreateStudentResponse> asyncHandler = new AsyncHandler<CreateStudentResponse>() {

			public void handleResponse(Response<CreateStudentResponse>  response) {
				Utils.trace(" in handler response" );
				if (!response.isCancelled()&& response.isDone()) {
					Student studentAdded = null ; 
				
					try {
						studentAdded = response.get().getReturn();
						Utils.trace(String.format(" student : %s added", studentAdded.toString() ));
						
					} catch (Exception exception) {
						Utils.trace(String.format("%s callback for response %s ", 
								exception.getClass().getName(),
								exception.getMessage()));
					}
					finally {
						Utils.trace(String.format(studentAdded.toString())); 
						
					}
					
				
				}else
					Utils.trace("else part "); 

			};

		};
		Utils.trace(" with callback" );
		studentWebPort.createStudentAsync(studentToAdd,asyncHandler);
		Utils.trace(" done with callback" );
		Utils.trace(studentToAdd.toString());
		
		

	}
	

}