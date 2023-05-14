package fr.emile.jsftuto.backingbean;


import javax.faces.bean.ManagedBean;

@ManagedBean(name = "userBean")
public class UserBean {
	private String firstname;
	private String lastname;
	private String dateOfBirth;
	private String email;

	
	
	public UserBean() {
		
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

	


}
