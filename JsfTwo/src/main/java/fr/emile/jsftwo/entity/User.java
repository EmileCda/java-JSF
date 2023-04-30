package fr.emile.jsftwo.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class User {

	private String firstname;
	private String lastname;
	private String genderText;
	private String dateText;
	private String email;
	private String levelText;
	
	

	
	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", genderText=" + genderText + ", dateText="
				+ dateText + ", email=" + email + ", levelText=" + levelText + "]";
	}




	public User(String firstname, String lastname, String genderText, String dateText, String email, String levelText) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.genderText = genderText;
		this.dateText = dateText;
		this.email = email;
		this.levelText = levelText;
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




	public String getGenderText() {
		return genderText;
	}




	public void setGenderText(String genderText) {
		this.genderText = genderText;
	}




	public String getDateText() {
		return dateText;
	}




	public void setDateText(String dateText) {
		this.dateText = dateText;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getLevelText() {
		return levelText;
	}




	public void setLevelText(String levelText) {
		this.levelText = levelText;
	}




	
	
	
}
