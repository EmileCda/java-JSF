package fr.emile.jsffour.backingbean;

import fr.emile.jsffour.entity.User;
import fr.emile.jsffour.backingbean.EnrollmentBean;

import java.util.ArrayList;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.emile.jsffour.common.IConstant;


@ManagedBean(name="enrollmentBean")
public class EnrollmentBean implements IConstant {

	private String firstname;
	private String lastname;
	private String gender = "1";
	private String birthdate;
	private String email;
	private String serviceLevel ="3";
	private String address;
	private String information;
	private static boolean isInstanced = false;
	private static List<User> userList ;

	

	public EnrollmentBean() {
		if (!EnrollmentBean.isInstanced()) {
			System.out.println("new userList");
			EnrollmentBean.setInstanced( true); 
			userList = new ArrayList<User>();
			
			userList.add(new User("Louis","Laforge","1","27/10/1977","emmed@ememd.fr","1" ));
			userList.add(new User("Benoit","Leclerc","1","27/10/1977","Benoit@eerimed.fr","1" ));
			userList.add(new User("Laura","Treich","1","27/10/1977","Laura@yaLaura.fr","1" ));
			
		}
		this.setInformation(String.format("[%d]-- \n",userList.size()));
		this.setFirstname("firstname");
		System.out.println("EnrollmentBean");
	}

	public EnrollmentBean(String firstname, String lastname, String gender, String email, String serviceLevel) {
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setGender(gender);
		this.setEmail(email);
		this.setServiceLevel(serviceLevel);
		this.setInformation("tout va bien ");
		this.setAddress("1, rue truc ");
	}

	
	public void addStudent() {
		
		this.setInformation("addStudent()");
		
		
		User user = new User(
				this.getFirstname(),
				this.getLastname(),
				this.getGender(),
				this.getBirthdate(),
				this.getEmail(),
				this.getServiceLevel());
			
		
		EnrollmentBean.getUserList().add(user);
		
	}
	public void delete() {
		this.setInformation("void delete()");
	}
	public void delete(User user) {
		
		this.setInformation("void delete(User user) vraiment");
		EnrollmentBean.getUserList().remove(user);

		
	}
	
	
	public String getFirstname() {
		this.setInformation("getFirstnamezz");
//		this.setInformation(this.getInformation()+ "getFirstnamezz");
		return this.firstname;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getServiceLevel() {
		return serviceLevel;
	}

	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}


	public String getInformation() {
		return information;
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

	public static boolean isInstanced() {
		return isInstanced;
	}

	public static void setInstanced(boolean isInstanced) {
		EnrollmentBean.isInstanced = isInstanced;
	}

	public static  List<User> getUserList() {
		return userList;
	}

	public  void setUserList(List<User> userList) {
		EnrollmentBean.userList = userList;
	}


	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
