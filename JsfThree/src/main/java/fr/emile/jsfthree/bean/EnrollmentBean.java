package fr.emile.jsfthree.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.emile.jsfthree.entity.User;



//@ManagedBean(name = "enrollmentBean", eager = true)
@ManagedBean(name = "enrollmentBean")
@SessionScoped
public class EnrollmentBean {

	private String firstname;
	private String lastname;
	private String gender;
	private String birthdate;
	private String email;
	private String serviceLevel;
	private String information;
	private static List<User> userList;

	

	public EnrollmentBean() {
		this("firstname","lastname","sexe","email","servicelevel");
	
	}

	public EnrollmentBean(String firstname, String lastname, String gender, String email, 
			String serviceLevel) {
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setGender(gender);
		this.setEmail(email);
		this.setServiceLevel(serviceLevel);
		this.setInformation("tout va bien ");
		userList = new ArrayList<User>();
	}

	
	public void addStudent() {

		User newUser = new User(
				this.getFirstname(),
				this.getLastname(),
				this.getGender(),
				this.getBirthdate(),
				this.getEmail(),
				this.getServiceLevel());
				
		userList.add(newUser);
	}
	
	
	
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getServiceLevel() {
		return this.serviceLevel;
	}

	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}


	public String getInformation() {
		return this.information;
	}

	public void setInformation(String information) {
		this.information = information;
	}


	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}


	public static List<User> getUserList() {
		return EnrollmentBean.userList;
	}

	public  void setUserList(List<User> userList) {
		EnrollmentBean.userList = userList;
	}



}
