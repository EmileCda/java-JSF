package fr.emile.jsfsix.backingbean;


import javax.faces.bean.ManagedBean;

@ManagedBean(name = "userBean")
public class UserBean {
	private String firstname;
	private String lastname;
	private String dateOfBirth;
	private String email;



	public UserBean() {

	}



	public String getDateOfBirth() {
		return dateOfBirth;
	}



	public String getEmail() {
		return email;
	}



	public String getFirstname() {
		return firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}




}
