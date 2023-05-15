package fr.emile.optim.backingbean;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.emile.optim.utils.Utils;

@ManagedBean(name = "userBean",eager = true)
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 5847036121136918717L;
	private String stringTexte = "tutu";
	private String firstname;
	               
	private String lastname;

	public UserBean() {
		this.setStringTexte("in Constructor");
		this.setFirstname("const firstname");
		this.setLastname("const last namee");
	}

	public String buttonClick() {

		this.setStringTexte("buttonClikc");

		Utils.trace("String buttonClick");
		return "un";

	}

	public String getStringTexte() {
		return stringTexte;
	}

	public void setStringTexte(String stringTexte) {
		this.stringTexte = stringTexte;
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


}
