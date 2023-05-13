package fr.emile.barman.main;



import fr.emile.barman.utils.Utils;
import fr.emile.barman.webservice.Exception_Exception;
import fr.emile.barman.webservice.Student;
import fr.emile.barman.webservice.StudentService;
import fr.emile.barman.webservice.StudentWebService;
import fr.emile.barman.webservice.StudentWebService_Service;

public class SyncAdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		StudentWebService_Service studentWebService = new StudentWebService_Service();
		StudentWebService studentWebPort =  studentWebService.getStudentWebServicePort();
		
		Student studentToAdd = new Student();
		String firstname = DataTest.firstname();
		String lastname = DataTest.lastname();
		studentToAdd.setFirstname(firstname);
		studentToAdd.setLastname(lastname);
		studentToAdd.setEmail(DataTest.email(firstname, lastname));
		studentToAdd.setSpeciality(DataTest.specialite());
		studentToAdd.setAge(DataTest.age(18, 100));
		
		Student studentAdded = null ;
		
		
		try {
			studentAdded = studentWebPort.addStudent(studentToAdd);
		} catch (Exception_Exception e) {
			Utils.trace("catch error"+ e.toString());
			e.printStackTrace();
		}finally {
		
			Utils.trace(studentAdded.toString());
		}
	}

}
