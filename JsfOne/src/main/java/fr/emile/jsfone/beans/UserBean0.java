package fr.emile.jsfone.beans;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.emile.jsfone.common.IConstant;


@ManagedBean( name ="userbean0" )
public class UserBean0 implements IConstant {
	
	private int id ; 
	@ManagedProperty(name = "firstname", value = "DUPONT")
	private String firstname ; 
	@ManagedProperty(name = "lastname", value = "MICHEL")
	private String lastname ; 
//	@ManagedProperty(name = "dateOfBirth", value = "Date de naissance")
	private String dateOfBirth ;
	@ManagedProperty(name = "email", value = "dupont.michel@doranco.fr")
	private String email;
//	@ManagedProperty(name = "password", value = "Mot de passe")
	private String password;
//	@ManagedProperty(name = "serviceLevel", value = "niveau de service")
	private String  serviceLevel;
	@ManagedProperty(name = "sexe", value = "Homme")
	private String  sexe;
	
	
	
	
	
	public UserBean0(int id, String firstname, String lastname, String dateOfBirth, String email, String serviceLevel) {
		this.setId(id);
		this.setFirstname (firstname);
		this.setLastname (lastname);
		this.setDateOfBirth (dateOfBirth);
		this.setEmail (email);
		this.setServiceLevel (serviceLevel);
	}
	public UserBean0() {
		
		this (DEFAULT_ID,"","","01/01/1900",DEFAULT_EMAIL,DEFAULT_SERVICE_LEVEL.getValue());
		
	}
	
	
	
	public String connect() {
		
		System.out.println("email" + this.getEmail());
		System.out.println("Password" + this.getPassword());
		
		return "" ;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getServiceLevel() {
		return serviceLevel;
	}
	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
