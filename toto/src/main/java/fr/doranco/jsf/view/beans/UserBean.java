package fr.doranco.jsf.view.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.jsf.entity.User;

@ManagedBean(name = "userbean")
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// injection de dépendance
	@ManagedProperty(value = "#{adressebean}")
	private static AdresseBean adresseBean;
	
	@ManagedProperty(name = "genre", value = "M.")
	private String genre;

	@ManagedProperty(name = "prenom", value = "Michel")
	private String prenom;
	
	@ManagedProperty(name = "nom", value = "DUPOND")
	private String nom;
	
	private Date dateNaissance;
	
	@ManagedProperty(name = "email", value = "michel.dupont@doranco.fr")
	private String email;

	private String password;
	private String passwordConfirmation;
	
	@ManagedProperty(value = "Medium")
	private String niveauService;
	
	private List<String> langagesSouhaites;
	
	private String messageSuccess;
	private String messageError;
	
	private static List<User> users = new ArrayList<User>();

	public UserBean() {
		messageSuccess = "";
		messageError = "";
	}

	public String addUser() {
		
		if (!password.equals(passwordConfirmation)) {
			messageError = "Les deux mots de passe ne correspondent pas ! Veuillez réessayer.";
			messageSuccess = "";
			return "";
		}
		
		// vérifier s'il n'existe pas un user dans la BDD qui possède l'adresse email
		// saisie ici par l'utilisateur
//		messageError = "L'adresse email saisie est déjà utilisée ! veuillez réessayer.";
//		return "";
		
		User user = new User();
		user.setGenre(genre);
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setDateNaissance(dateNaissance);
		user.setEmail(email);
		user.setNiveauService(niveauService);
		user.setPassword(password);
		langagesSouhaites.forEach(langage -> user.getLangagesSouhaites().add(langage));
		
		adresseBean.getAdresses().forEach(a -> user.getAdresses().add(a));
		
		users.add(user);
		
		messageSuccess = "Compte créé avec succès.";
		messageError = "";
		adresseBean.getAdresses().clear();
		adresseBean.initializeAdresse();
		initializeUser();
		
		return "";
	}
	
	public void deleteUser(User user) {
		users.remove(user);
		messageSuccess = "Utilisateur supprimé avec succès.";
		messageError = "";
	}

	private void initializeUser() {
		this.nom = "";
		this.prenom = "";
		this.email = "";
		this.genre = "";
		this.niveauService = "";
		this.langagesSouhaites.clear();
		this.dateNaissance = null;
	}
	
	public AdresseBean getAdresseBean() {
		return adresseBean;
	}

	public void setAdresseBean(AdresseBean adresseBean) {
		this.adresseBean = adresseBean;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
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

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public String getNiveauService() {
		return niveauService;
	}

	public void setNiveauService(String niveauService) {
		this.niveauService = niveauService;
	}

	public List<String> getLangagesSouhaites() {
		return langagesSouhaites;
	}

	public void setLangagesSouhaites(List<String> langagesSouhaites) {
		this.langagesSouhaites = langagesSouhaites;
	}

	public String getMessageSuccess() {
		return messageSuccess;
	}

	public void setMessageSuccess(String messageSuccess) {
		this.messageSuccess = messageSuccess;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

	public List<User> getUsers() {
		return users;
	}
	
}
