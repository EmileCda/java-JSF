package fr.emile.bluemoon.backingbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.emile.bluemoon.utils.Utils;

@Named
@ManagedBean( eager = true)
@SessionScoped
public class UserBean {

	private String firstname;
	private String lastname;
	private String gender;
	private String birthdate;
	private String email;

	public UserBean() {
		this("","","","","");
		this.setFirstname("toto firstname");
		Utils.trace("UserBean");
		
	}

	public UserBean(String firstname, String lastname, String gender, String birthdate, String email) {
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setGender(gender);
		this.setBirthdate(birthdate);
		this.setEmail(email);
	}

	public void addBankCard() {

		addMessage("addBankCard");
		Utils.trace("addBankCard");
		Utils.trace(this.toString());

	}

	public void addAddress() {

		addMessage("addAddress");
		Utils.trace("addAddress");
		Utils.trace(this.toString());
		this.setLastname("addAddress");
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

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s %s ", getGender(), getFirstname(), getLastname(), getBirthdate(), getEmail());
	}
	
	  public void addMessage(String summary) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }

}
