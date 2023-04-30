package fr.emile.jsftwo.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;


import fr.emile.jsftwo.entity.User;

@ManagedBean(name="userBean")

public class UserBean {

	private String firstname;
	private String lastname;
	private String dateOfBirth;
	private String email;
	private String password;
	private String genderText;
	private String serviceLevel;

	private List<User> userList;

	public UserBean() {
		
//		if (userList == null) {
//			userList = new ArrayList<User>();
//			this.add(new User("ZZandrée", "deGaule", "femme", "17/11/1277", "andrée@ddeGaulee.fr", "Basic"));
//			this.add(new User("Paul", "Andrieux", "homme", "12/06/1965", "paul.andrieu@dommile.fr", "Medium"));
//			this.add(new User("Benoit", "Leclerc", "homme", "27/10/1977", "Benoit@dommile.fr", "Premium"));
//		}
	}

	public String connect() {

		System.out.println("email" + this.getEmail());
		System.out.println("Password" + this.getPassword());

		return "";

	}

	public String createAccount() {

		System.out.printf("createAccount");
//		User user = new User(this.getFirstname(), this.getLastname(), this.getGenderText(), this.getGenderText(),
//				this.getEmail(), this.getServiceLevel());
//		System.out.printf("public String  createAccount(User user) : %s : [%d]\n", user,userList.size());
//
//		System.out.println("user" + user);
//
////		this.add(user);
//		if (userList == null) {
//			userList = new ArrayList<User>();
//		}
//		this.getUserList().add(user);
		System.out.printf("public String  createAccount(User user) : %s : [%d]\n", user,userList.size());
		
		return "createAccount";

	}

	public boolean add(User user) {

		return this.userList.add(user);
	}

	public String delete(User user) {

		System.out.printf("public String  delete(User user) : %s", user);

		this.userList.remove(user);
		return "delete";
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGenderText() {
		return genderText;
	}

	public void setGenderText(String gender) {
		this.genderText = gender;
	}

	public String getServiceLevel() {
		return serviceLevel;
	}

	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	public List<User> getUserList() {
		return userList;
	}

}
