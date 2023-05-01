package fr.emile.jsftuto.backingbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.emile.jsftuto.entity.User;
import fr.emile.jsftuto.utils.Utils;



@ManagedBean(name = "enrollmentBean", eager = true)
@SessionScoped
public class EnrollmentBean {

	private String firstname;
	private String lastname;
	private String gender;
	private String birthdate;
	private String email;
	private String serviceLevel;
	private String address;
	private String information;
	private static boolean isInstanced = false;
	private static List<User> userList ;
	private List<User> userListDisplay; ;

	

	public EnrollmentBean() {
		if (!this.isInstanced()) {
			System.out.println("ici");
			this.setInstanced( true); 
			userList = new ArrayList<User>();
			
			userList.add(new User("Louis","Laforge",1,Utils.string2Date("20/12/2000", "dd/MM/yyyy"),"emmed@ememd.fr",1 ));
			userList.add(new User("Benoit","Leclerc",1,Utils.string2Date("27/10/1977", "dd/MM/yyyy"),"Benoit@eerimed.fr",1 ));
			userList.add(new User("Laura","Treich",1,Utils.string2Date("07/10/1997", "dd/MM/yyyy"),"Laura@yaLaura.fr",1 ));
			
		}
		userListDisplay = new ArrayList<User>();
		userListDisplay  = userList ;
		this.setInformation(String.format("[%d]--[%d] \n",userList.size(),userListDisplay.size()));
		System.out.println("ici");
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
		
		this.setInformation("public void addStudent()");
		User user = new User(
				this.getFirstname(),
				this.getLastname(),
				this.getGender(),
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

	public static List<User> getUserList() {
		return userList;
	}

	public  void setUserList(List<User> userList) {
		EnrollmentBean.userList = userList;
	}


	public List<User> getUserListDisplay() {
		return userListDisplay;
	}

	public void setUserListDisplay(List<User> userListDisplay) {
		this.userListDisplay = userListDisplay;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
