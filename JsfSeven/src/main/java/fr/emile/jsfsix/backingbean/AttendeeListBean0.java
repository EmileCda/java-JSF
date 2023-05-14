package fr.emile.jsfsix.backingbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.emile.jsfsix.common.IConstant;
import fr.emile.jsfsix.entity.Student;
import fr.emile.jsfsix.model.dao.IStudentDao;
import fr.emile.jsfsix.model.dao.StudentDao;


public class AttendeeListBean0 implements IConstant  {
	private String firstname;
	private String lastname;
	private String email;
	private String birthdate;
	private String serviceLevel;
	private String address;
	private String phone;
	private String position;
	private String available;
	private String langList;

	List<Student> attendeeList ; 
	
	
	public AttendeeListBean0(String firstname, String lastname, String email, String birthdate, String serviceLevel,
			String address, String phone, String position, String available, String langList
			) {
		this.setFirstname ( firstname);
		this.setLastname ( lastname);
		this.setEmail ( email);
		this.setBirthdate ( birthdate);
		this.setServiceLevel ( serviceLevel);
		this.setAddress ( address);
		this.setPhone ( phone);
		this.setPosition ( position);
		this.setAvailable ( available);
		this.setLangList ( langList);
		this.attendeeList = new ArrayList<Student>();
	}


	public AttendeeListBean0() {
		
		this.attendeeList = new ArrayList<Student>();
		
		if (this.getAttendeeList().size()<=0 ) {
			
			this.initAttendeeList();
		}
		
		
	}

	public void initAttendeeList() {
		final IStudentDao myStudentDao = new StudentDao();
		try {
			System.out.println("iciiii");
			this.setAttendeeList( myStudentDao.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	
	public void modify(Student student){
		
		
		
	}
	public void delete(Student student){
		
		this.getAttendeeList().remove(student);
		
	}

	
	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}


	public String getServiceLevel() {
		return serviceLevel;
	}


	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getAvailable() {
		return available;
	}


	public void setAvailable(String available) {
		this.available = available;
	}


	public String getLangList() {
		return this.langList;
	}


	public void setLangList(String langList) {
		this.langList = langList;
	}


	public List<Student> getAttendeeList() {
		return attendeeList;
	}


	public void setAttendeeList(List<Student> attendeeList) {
		this.attendeeList = attendeeList;
	}



}
