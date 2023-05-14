package fr.emile.jsfsix.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.emile.jsfsix.utils.Utils;

public class UserOld {
	private String firstname;
	private String lastname;
	private int gender;
	private Date birthdate;
	private String email;
	private int serviceLevel;
	private List<Address> addressList ;


	public UserOld(String firstname, String lastname, int gender, Date birthdate, String email, int serviceLevel) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.birthdate = birthdate;
		this.email = email;
		this.serviceLevel = serviceLevel;
		addressList = new ArrayList<>();
	}

	public UserOld(String firstname, String lastname, String gender,  String email, String serviceLevel) {
		this(firstname,lastname,1,Utils.string2Date("25/12/2023", "dd/MM/yyyy"),email,1);
	}

	public Date getBirthdate() {
		return birthdate;
	}
	public String getBirthdateText() {
		return Utils.date2String(this.getBirthdate(),"dd/MM/yyyy");
	}
	public String getEmail() {
		return email;
	}
	public String getFirstname() {
		return firstname;
	}
	public int getGender() {
		return gender;
	}
	public String getLastname() {
		return lastname;
	}
	public int getServiceLevel() {
		return serviceLevel;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setServiceLevel(int serviceLevel) {
		this.serviceLevel = serviceLevel;
	}
	@Override
	public String toString() {
		return "User  "+getFirstname() +" " +  getLastname() +
				" "+  getGender() +
				" " + getBirthdate() +
				" " + getEmail()+
				" " + getServiceLevel() + " ";
	}

}
